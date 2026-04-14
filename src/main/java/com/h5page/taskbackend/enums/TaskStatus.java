package com.h5page.taskbackend.enums;

/**
 * Task status lifecycle for client display and backend processing.
 */
public enum TaskStatus {
    LOCKED("locked", "未解锁"),
    AVAILABLE("available", "可开始"),
    IN_PROGRESS("in_progress", "进行中"),
    COMPLETED("completed", "已完成"),
    CLAIMABLE("claimable", "可领取"),
    CLAIMED("claimed", "已领取");

    private final String code;
    private final String label;

    TaskStatus(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
