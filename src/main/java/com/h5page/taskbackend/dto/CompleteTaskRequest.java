package com.h5page.taskbackend.dto;

/**
 * Request payload to complete a task.
 */
public class CompleteTaskRequest {
    /** Task id to complete. */
    private String taskId;
    /** Task type code for validation or routing. */
    private String type;
    /** Extra payload from client for custom logic. */
    private Object extra;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
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
