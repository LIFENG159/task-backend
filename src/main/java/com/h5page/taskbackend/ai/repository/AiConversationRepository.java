package com.h5page.taskbackend.ai.repository;

import com.h5page.taskbackend.ai.entity.AiConversationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AiConversationRepository extends JpaRepository<AiConversationEntity, String> {
    List<AiConversationEntity> findByUserIdOrderByUpdatedAtDesc(String userId);
}
