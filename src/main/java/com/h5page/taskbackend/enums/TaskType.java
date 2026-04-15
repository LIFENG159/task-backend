package com.h5page.taskbackend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Task type definitions used by both frontend and backend.
 */
public enum TaskType {
    BROWSE_JUMP_COUNTDOWN("browse_jump_countdown", "浏览跳转倒计时"),
    BUBBLE_SCROLL_COUNTDOWN("bubble_scroll_countdown", "气泡下滑倒计时"),
    DIVERSION_ORDER("diversion_order", "导流下单"),
    DELAYED_CLAIM("delayed_claim", "倒计时领取");

    private final String code;
    private final String label;

    TaskType(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    @JsonValue
    public String toJson() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
