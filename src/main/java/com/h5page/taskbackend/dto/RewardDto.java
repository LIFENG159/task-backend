package com.h5page.taskbackend.dto;

/**
 * Reward payload for a task.
 */
public class RewardDto {
    /** Points earned for this task. */
    private Integer points;
    /** Optional coupon id. */
    private String couponId;
    /** Display label for the reward. */
    private String label;

    public RewardDto() {
    }

    public RewardDto(Integer points, String label) {
        this.points = points;
        this.label = label;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
