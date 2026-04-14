package com.h5page.taskbackend.ai.dto;

public class AiChatResponse {
    private String conversationId;
    private String answer;

    public AiChatResponse() {
    }

    public AiChatResponse(String conversationId, String answer) {
        this.conversationId = conversationId;
        this.answer = answer;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
