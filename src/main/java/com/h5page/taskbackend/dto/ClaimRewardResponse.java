package com.h5page.taskbackend.dto;

/**
 * Response payload after reward claiming.
 */
public class ClaimRewardResponse {
    /** Reward detail returned to client. */
    private RewardDto reward;
    /** Updated task state after claim. */
    private TaskItemDto task;

    public ClaimRewardResponse() {
    }

    public ClaimRewardResponse(RewardDto reward, TaskItemDto task) {
        this.reward = reward;
        this.task = task;
    }

    public RewardDto getReward() {
        return reward;
    }

    public void setReward(RewardDto reward) {
        this.reward = reward;
    }

    public TaskItemDto getTask() {
        return task;
    }

    public void setTask(TaskItemDto task) {
        this.task = task;
    }
}
