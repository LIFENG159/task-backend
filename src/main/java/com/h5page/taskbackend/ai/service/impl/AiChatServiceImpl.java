package com.h5page.taskbackend.ai.service.impl;

import com.h5page.taskbackend.ai.dto.AiChatRequest;
import com.h5page.taskbackend.ai.dto.AiChatResponse;
import com.h5page.taskbackend.ai.dto.AiConversationDto;
import com.h5page.taskbackend.ai.dto.AiMessageDto;
import com.h5page.taskbackend.ai.entity.AiConversationEntity;
import com.h5page.taskbackend.ai.entity.AiMessageEntity;
import com.h5page.taskbackend.ai.ollama.OllamaClient;
import com.h5page.taskbackend.ai.ollama.dto.OllamaChatRequest;
import com.h5page.taskbackend.ai.ollama.dto.OllamaChatResponse;
import com.h5page.taskbackend.ai.repository.AiConversationRepository;
import com.h5page.taskbackend.ai.repository.AiMessageRepository;
import com.h5page.taskbackend.ai.service.AiChatService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class AiChatServiceImpl implements AiChatService {
    private final AiConversationRepository conversationRepository;
    private final AiMessageRepository messageRepository;
    private final OllamaClient ollamaClient;

    public AiChatServiceImpl(
            AiConversationRepository conversationRepository,
            AiMessageRepository messageRepository,
            OllamaClient ollamaClient
    ) {
        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
        this.ollamaClient = ollamaClient;
    }

    @Override
    public AiChatResponse chat(AiChatRequest request) {
        // 获取或创建会话，保证消息落库
        AiConversationEntity conversation = getOrCreateConversation(request.getConversationId(), request.getUserId());
        // 保存用户消息
        saveMessage(conversation.getId(), "user", request.getMessage());

        // 组装本地模型请求
        OllamaChatRequest ollamaRequest = new OllamaChatRequest();
        ollamaRequest.addMessage("system", "You are a helpful assistant for task activities.");
        ollamaRequest.addMessage("user", request.getMessage());

        // 调用 Ollama 获取回答
        OllamaChatResponse response = ollamaClient.chat(ollamaRequest);
        String answer = response != null ? response.getMessageContent() : "";
        if (answer == null) {
            answer = "";
        }
        // 保存 AI 回复
        saveMessage(conversation.getId(), "assistant", answer);

        // 更新会话更新时间
        conversation.setUpdatedAt(Instant.now().toEpochMilli());
        conversationRepository.save(conversation);

        return new AiChatResponse(conversation.getId(), answer);
    }

    @Override
    public List<AiConversationDto> listConversations(String userId) {
        return conversationRepository.findByUserIdOrderByUpdatedAtDesc(userId)
                .stream()
                .map(this::toConversationDto)
                .toList();
    }

    @Override
    public List<AiMessageDto> listMessages(String conversationId) {
        return messageRepository.findByConversationIdOrderByCreatedAtAsc(conversationId)
                .stream()
                .map(this::toMessageDto)
                .toList();
    }

    private AiConversationEntity getOrCreateConversation(String conversationId, String userId) {
        // 如果有会话 id 就优先复用
        if (conversationId != null && !conversationId.isBlank()) {
            return conversationRepository.findById(conversationId)
                    .orElseGet(() -> createConversation(userId));
        }
        return createConversation(userId);
    }

    private AiConversationEntity createConversation(String userId) {
        // 创建新的会话记录
        long now = Instant.now().toEpochMilli();
        AiConversationEntity entity = new AiConversationEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setUserId(userId);
        entity.setTitle("New Chat");
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
        return conversationRepository.save(entity);
    }

    private void saveMessage(String conversationId, String role, String content) {
        // 持久化每条消息
        AiMessageEntity message = new AiMessageEntity();
        message.setId(UUID.randomUUID().toString());
        message.setConversationId(conversationId);
        message.setRole(role);
        message.setContent(content);
        message.setCreatedAt(Instant.now().toEpochMilli());
        messageRepository.save(message);
    }

    private AiConversationDto toConversationDto(AiConversationEntity entity) {
        AiConversationDto dto = new AiConversationDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    private AiMessageDto toMessageDto(AiMessageEntity entity) {
        AiMessageDto dto = new AiMessageDto();
        dto.setId(entity.getId());
        dto.setRole(entity.getRole());
        dto.setContent(entity.getContent());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}
