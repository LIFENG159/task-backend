package com.h5page.taskbackend.service;

import com.h5page.taskbackend.dto.ClaimRewardResponse;
import com.h5page.taskbackend.dto.CompleteTaskRequest;
import com.h5page.taskbackend.dto.ProgressReportRequest;
import com.h5page.taskbackend.dto.TaskItemDto;

import java.util.List;

/**
 * Task business operations.
 */
public interface TaskService {
    /** Fetch tasks by user and activity. */
    List<TaskItemDto> getTasks(String userId, String activityId);

    /** Complete a task and update status. */
    TaskItemDto completeTask(CompleteTaskRequest request);

    /** Claim reward for a task. */
    ClaimRewardResponse claimReward(String taskId, String userId, String activityId);

    /** Report progress for a running countdown task. */
    void reportProgress(ProgressReportRequest request);
}
