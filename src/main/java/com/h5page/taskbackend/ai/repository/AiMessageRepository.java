package com.h5page.taskbackend.ai.repository;

import com.h5page.taskbackend.ai.entity.AiMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AiMessageRepository extends JpaRepository<AiMessageEntity, String> {
    List<AiMessageEntity> findByConversationIdOrderByCreatedAtAsc(String conversationId);
}
