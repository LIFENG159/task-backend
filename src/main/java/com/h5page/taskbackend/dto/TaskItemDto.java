package com.h5page.taskbackend.dto;

import com.h5page.taskbackend.enums.TaskStatus;
import com.h5page.taskbackend.enums.TaskType;

/**
 * Task data returned to the frontend.
 */
public class TaskItemDto {
    /** Unique task identifier. */
    private String id;
    /** Task type used by the SDK to decide behaviors. */
    private TaskType type;
    /** Display title shown to users. */
    private String title;
    /** Current lifecycle status. */
    private TaskStatus status;
    /** Reward information associated with the task. */
    private RewardDto reward;
    /** Task configuration values (durations, channels, urls). */
    private TaskConfigDto config;
    /** Optional progress state reported by client. */
    private TaskProgressDto progress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public RewardDto getReward() {
        return reward;
    }

    public void setReward(RewardDto reward) {
        this.reward = reward;
    }

    public TaskConfigDto getConfig() {
        return config;
    }

    public void setConfig(TaskConfigDto config) {
        this.config = config;
    }

    public TaskProgressDto getProgress() {
        return progress;
    }

    public void setProgress(TaskProgressDto progress) {
        this.progress = progress;
    }
}
