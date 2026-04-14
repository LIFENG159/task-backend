package com.h5page.taskbackend.service.impl;

import com.h5page.taskbackend.dto.EnumItemDto;
import com.h5page.taskbackend.enums.TaskStatus;
import com.h5page.taskbackend.enums.TaskType;
import com.h5page.taskbackend.service.EnumService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Default enum service that exposes enum lists by name.
 */
@Service
public class EnumServiceImpl implements EnumService {
    @Override
    public List<EnumItemDto> getEnumItems(String enumName) {
        // Allow the frontend to query enums by class name.
        if ("TaskType".equalsIgnoreCase(enumName)) {
            List<EnumItemDto> items = new ArrayList<>();
            for (TaskType value : TaskType.values()) {
                items.add(new EnumItemDto(value.getCode(), value.getLabel()));
            }
            return items;
        }
        if ("TaskStatus".equalsIgnoreCase(enumName)) {
            List<EnumItemDto> items = new ArrayList<>();
            for (TaskStatus value : TaskStatus.values()) {
                items.add(new EnumItemDto(value.getCode(), value.getLabel()));
            }
            return items;
        }
        return List.of();
    }
}
