package com.h5page.taskbackend.service.impl;

import com.h5page.taskbackend.dto.ClaimRewardResponse;
import com.h5page.taskbackend.dto.CompleteTaskRequest;
import com.h5page.taskbackend.dto.ProgressReportRequest;
import com.h5page.taskbackend.dto.RewardDto;
import com.h5page.taskbackend.dto.TaskConfigDto;
import com.h5page.taskbackend.dto.TaskItemDto;
import com.h5page.taskbackend.dto.TaskProgressDto;
import com.h5page.taskbackend.entity.RewardEmbeddable;
import com.h5page.taskbackend.entity.TaskConfigEmbeddable;
import com.h5page.taskbackend.entity.TaskEntity;
import com.h5page.taskbackend.entity.TaskProgressEmbeddable;
import com.h5page.taskbackend.enums.TaskStatus;
import com.h5page.taskbackend.enums.TaskType;
import com.h5page.taskbackend.repository.TaskRepository;
import com.h5page.taskbackend.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * JPA-based task service implementation.
 */
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskItemDto> getTasks(String userId, String activityId) {
        // Filter by user/activity when provided, otherwise return all tasks.
        List<TaskEntity> entities;
        if (userId != null && activityId != null) {
            entities = taskRepository.findByUserIdAndActivityId(userId, activityId);
        } else if (userId != null) {
            entities = taskRepository.findByUserId(userId);
        } else if (activityId != null) {
            entities = taskRepository.findByActivityId(activityId);
        } else {
            entities = taskRepository.findAll();
        }
        return entities.stream().map(this::toDto).toList();
    }

    @Override
    public TaskItemDto completeTask(CompleteTaskRequest request) {
        // Mark a task as completed when the client finishes required action.
        Optional<TaskEntity> optional = taskRepository.findById(request.getTaskId());
        if (optional.isEmpty()) {
            return null;
        }
        TaskEntity entity = optional.get();
        if (entity.getType() == TaskType.DELAYED_CLAIM) {
            entity.setStatus(TaskStatus.CLAIMABLE);
        } else {
            entity.setStatus(TaskStatus.COMPLETED);
        }
        TaskEntity saved = taskRepository.save(entity);
        return toDto(saved);
    }

    @Override
    public ClaimRewardResponse claimReward(String taskId, String userId, String activityId) {
        // Update task status to claimed and return reward payload.
        Optional<TaskEntity> optional = taskRepository.findById(taskId);
        if (optional.isEmpty()) {
            return null;
        }
        TaskEntity entity = optional.get();
        entity.setStatus(TaskStatus.CLAIMED);
        TaskEntity saved = taskRepository.save(entity);
        TaskItemDto dto = toDto(saved);
        return new ClaimRewardResponse(dto.getReward(), dto);
    }

    @Override
    public void reportProgress(ProgressReportRequest request) {
        // Persist countdown progress for long-running tasks.
        Optional<TaskEntity> optional = taskRepository.findById(request.getTaskId());
        if (optional.isEmpty()) {
            return;
        }
        TaskEntity entity = optional.get();
        TaskProgressEmbeddable progress = new TaskProgressEmbeddable();
        if (request.getProgress() != null) {
            progress.setRemainingSeconds(request.getProgress().getRemainingSeconds());
            progress.setStartedAt(request.getProgress().getStartedAt());
        }
        entity.setProgress(progress);
        entity.setStatus(TaskStatus.IN_PROGRESS);
        taskRepository.save(entity);
    }

    private TaskItemDto toDto(TaskEntity entity) {
        // Map entity fields to API DTOs.
        TaskItemDto dto = new TaskItemDto();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setStatus(entity.getStatus());
        dto.setTitle(entity.getTitle());

        RewardEmbeddable reward = entity.getReward();
        if (reward != null) {
            RewardDto rewardDto = new RewardDto();
            rewardDto.setPoints(reward.getPoints());
            rewardDto.setCouponId(reward.getCouponId());
            rewardDto.setLabel(reward.getLabel());
            dto.setReward(rewardDto);
        }

        TaskConfigEmbeddable config = entity.getConfig();
        if (config != null) {
            TaskConfigDto configDto = new TaskConfigDto();
            configDto.setDurationSeconds(config.getDurationSeconds());
            configDto.setClaimDelaySeconds(config.getClaimDelaySeconds());
            configDto.setJumpUrl(config.getJumpUrl());
            configDto.setBubbleId(config.getBubbleId());
            configDto.setOrderChannel(config.getOrderChannel());
            dto.setConfig(configDto);
        }

        TaskProgressEmbeddable progress = entity.getProgress();
        if (progress != null) {
            TaskProgressDto progressDto = new TaskProgressDto();
            progressDto.setRemainingSeconds(progress.getRemainingSeconds());
            progressDto.setStartedAt(progress.getStartedAt());
            dto.setProgress(progressDto);
        }

        return dto;
    }
}
