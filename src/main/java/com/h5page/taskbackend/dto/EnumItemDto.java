package com.h5page.taskbackend.dto;

/**
 * Generic enum item for frontend consumption.
 */
public class EnumItemDto {
    /** Enum code value. */
    private String code;
    /** Enum display label. */
    private String label;

    public EnumItemDto() {
    }

    public EnumItemDto(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
