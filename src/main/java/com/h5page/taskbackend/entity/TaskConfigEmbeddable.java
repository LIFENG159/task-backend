package com.h5page.taskbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TaskConfigEmbeddable {
    @Column(name = "config_duration_seconds")
    private Integer durationSeconds;

    @Column(name = "config_claim_delay_seconds")
    private Integer claimDelaySeconds;

    @Column(name = "config_jump_url")
    private String jumpUrl;

    @Column(name = "config_bubble_id")
    private String bubbleId;

    @Column(name = "config_order_channel")
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
