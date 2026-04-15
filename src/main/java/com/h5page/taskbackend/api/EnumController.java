package com.h5page.taskbackend.api;

import com.h5page.taskbackend.common.ApiResponse;
import com.h5page.taskbackend.dto.EnumItemDto;
import com.h5page.taskbackend.service.EnumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Enum API for frontend to load enum lists by class name.
 */
@RestController
@RequestMapping("/api/enums")
public class EnumController {
    private final EnumService enumService;

    public EnumController(EnumService enumService) {
        this.enumService = enumService;
    }

    @GetMapping("/{enumName}")
    public ApiResponse<List<EnumItemDto>> getEnums(@PathVariable("enumName") String enumName) {
        // Example: /api/enums/TaskType or /api/enums/TaskStatus
        return ApiResponse.success(enumService.getEnumItems(enumName));
    }
}
