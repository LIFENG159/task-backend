package com.h5page.taskbackend.service;

import com.h5page.taskbackend.dto.EnumItemDto;

import java.util.List;

/**
 * Enum lookup service for frontend consumption.
 */
public interface EnumService {
    /**
     * Return enum items by enum name, e.g. TaskType or TaskStatus.
     */
    List<EnumItemDto> getEnumItems(String enumName);
}
