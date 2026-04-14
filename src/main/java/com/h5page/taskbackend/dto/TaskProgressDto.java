package com.h5page.taskbackend.dto;

/**
 * Progress data reported by client for countdown tasks.
 */
public class TaskProgressDto {
    /** Remaining seconds for countdown tasks. */
    private Integer remainingSeconds;
    /** Task start timestamp in milliseconds. */
    private Long startedAt;

    public Integer getRemainingSeconds() {
        return remainingSeconds;
    }

    public void setRemainingSeconds(Integer remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
    }

    public Long getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Long startedAt) {
        this.startedAt = startedAt;
    }
}
