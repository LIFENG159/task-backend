package com.h5page.taskbackend.dto;

/**
 * Request payload to claim task reward.
 */
public class ClaimRewardRequest {
    /** Task id to claim. */
    private String taskId;
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
