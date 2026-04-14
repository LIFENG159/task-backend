package com.h5page.taskbackend.entity;

import com.h5page.taskbackend.enums.TaskStatus;
import com.h5page.taskbackend.enums.TaskType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Task entity stored in the database.
 */
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    /** Primary key. */
    private String id;

    /** User scope for the task. */
    private String userId;

    /** Activity scope for the task. */
    private String activityId;

    /** Task type identifier. */
    @Enumerated(EnumType.STRING)
    private TaskType type;

    /** Display title. */
    private String title;

    /** Task status in lifecycle. */
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    /** Embedded reward fields. */
    @Embedded
    private RewardEmbeddable reward;

    /** Embedded config fields. */
    @Embedded
    private TaskConfigEmbeddable config;

    /** Embedded progress fields. */
    @Embedded
    private TaskProgressEmbeddable progress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public RewardEmbeddable getReward() {
        return reward;
    }

    public void setReward(RewardEmbeddable reward) {
        this.reward = reward;
    }

    public TaskConfigEmbeddable getConfig() {
        return config;
    }

    public void setConfig(TaskConfigEmbeddable config) {
        this.config = config;
    }

    public TaskProgressEmbeddable getProgress() {
        return progress;
    }

    public void setProgress(TaskProgressEmbeddable progress) {
        this.progress = progress;
    }
}
