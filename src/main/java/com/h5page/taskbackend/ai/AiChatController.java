package com.h5page.taskbackend.ai;

import com.h5page.taskbackend.ai.dto.AiChatRequest;
import com.h5page.taskbackend.ai.dto.AiChatResponse;
import com.h5page.taskbackend.ai.dto.AiConversationDto;
import com.h5page.taskbackend.ai.dto.AiMessageDto;
import com.h5page.taskbackend.ai.service.AiChatService;
import com.h5page.taskbackend.common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * AI chat API endpoints for frontend assistant.
 */
@RestController
@RequestMapping("/api/ai")
public class AiChatController {
    private final AiChatService chatService;

    public AiChatController(AiChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public ApiResponse<AiChatResponse> chat(@RequestBody AiChatRequest request) {
        // 前端提问入口，返回 AI 回复与会话 id
        return ApiResponse.success(chatService.chat(request));
    }

    @GetMapping("/conversations")
    public ApiResponse<List<AiConversationDto>> conversations(@RequestParam String userId) {
        // 获取用户的历史会话列表
        return ApiResponse.success(chatService.listConversations(userId));
    }

    @GetMapping("/messages/{conversationId}")
    public ApiResponse<List<AiMessageDto>> messages(@PathVariable String conversationId) {
        // 获取指定会话的消息列表
        return ApiResponse.success(chatService.listMessages(conversationId));
    }
}
