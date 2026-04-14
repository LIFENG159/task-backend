package com.h5page.taskbackend.repository;

import com.h5page.taskbackend.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Task JPA repository with basic query helpers.
 */
public interface TaskRepository extends JpaRepository<TaskEntity, String> {
    List<TaskEntity> findByUserIdAndActivityId(String userId, String activityId);

    List<TaskEntity> findByUserId(String userId);

    List<TaskEntity> findByActivityId(String activityId);
}
