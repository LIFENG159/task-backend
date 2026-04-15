package com.h5page.taskbackend.api;

import com.h5page.taskbackend.common.ApiResponse;
import com.h5page.taskbackend.dto.ClaimRewardRequest;
import com.h5page.taskbackend.dto.ClaimRewardResponse;
import com.h5page.taskbackend.dto.CompleteTaskRequest;
import com.h5page.taskbackend.dto.ProgressReportRequest;
import com.h5page.taskbackend.dto.TaskItemDto;
import com.h5page.taskbackend.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Task APIs used by SDK and frontend.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ApiResponse<List<TaskItemDto>> getTasks(
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "activityId", required = false) String activityId) {
        // Query tasks by user/activity if provided.
        return ApiResponse.success(taskService.getTasks(userId, activityId));
    }

    @PostMapping("/complete")
    public ApiResponse<TaskItemDto> complete(@RequestBody CompleteTaskRequest request) {
        // Complete a task and update status.
        TaskItemDto task = taskService.completeTask(request);
        return ApiResponse.success(task);
    }

    @PostMapping("/claim")
    public ApiResponse<ClaimRewardResponse> claim(@RequestBody ClaimRewardRequest request) {
        // Claim reward for a completed or claimable task.
        ClaimRewardResponse response = taskService.claimReward(
                request.getTaskId(),
                request.getUserId(),
                request.getActivityId()
        );
        return ApiResponse.success(response);
    }

    @PostMapping("/progress")
    public ApiResponse<Void> reportProgress(@RequestBody ProgressReportRequest request) {
        // Accept progress updates for countdown tasks.
        taskService.reportProgress(request);
        return ApiResponse.success(null);
    }
}
