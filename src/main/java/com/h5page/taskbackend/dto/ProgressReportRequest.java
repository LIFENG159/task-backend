package com.h5page.taskbackend.dto;

/**
 * Request payload to report progress for a running task.
 */
public class ProgressReportRequest {
    /** Task id to update. */
    private String taskId;
    /** Progress payload (remaining time, start timestamp). */
    private TaskProgressDto progress;
    /** User identifier. */
    private String userId;
    /** Activity identifier. */
    private String activityId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public TaskProgressDto getProgress() {
        return progress;
    }

    public void setProgress(TaskProgressDto progress) {
        this.progress = progress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
}
