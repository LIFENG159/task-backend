package com.h5page.taskbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RewardEmbeddable {
    @Column(name = "reward_points")
    private Integer points;

    @Column(name = "reward_coupon_id")
    private String couponId;

    @Column(name = "reward_label")
    private String label;

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
