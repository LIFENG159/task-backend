package com.h5page.taskbackend.ai.service;

import com.h5page.taskbackend.ai.dto.AiChatRequest;
import com.h5page.taskbackend.ai.dto.AiChatResponse;
import com.h5page.taskbackend.ai.dto.AiConversationDto;
import com.h5page.taskbackend.ai.dto.AiMessageDto;

import java.util.List;

public interface AiChatService {
    AiChatResponse chat(AiChatRequest request);

    List<AiConversationDto> listConversations(String userId);

    List<AiMessageDto> listMessages(String conversationId);
}
