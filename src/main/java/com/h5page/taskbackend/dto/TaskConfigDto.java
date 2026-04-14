package com.h5page.taskbackend.dto;

/**
 * Task configuration values that drive client timing and navigation.
 */
public class TaskConfigDto {
    /** Countdown duration for browse/bubble tasks. */
    private Integer durationSeconds;
    /** Delay seconds before a claimable task can be领取. */
    private Integer claimDelaySeconds;
    /** Jump url for browse tasks. */
    private String jumpUrl;
    /** Bubble identifier used by the client. */
    private String bubbleId;
    /** Order channel identifier for diversion tasks. */
    private String orderChannel;

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Integer getClaimDelaySeconds() {
        return claimDelaySeconds;
    }

    public void setClaimDelaySeconds(Integer claimDelaySeconds) {
        this.claimDelaySeconds = claimDelaySeconds;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getBubbleId() {
        return bubbleId;
    }

    public void setBubbleId(String bubbleId) {
        this.bubbleId = bubbleId;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }
}
