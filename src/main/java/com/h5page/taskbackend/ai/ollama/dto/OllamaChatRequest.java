package com.h5page.taskbackend.ai.ollama.dto;

import java.util.ArrayList;
import java.util.List;

public class OllamaChatRequest {
    private String model;
    private List<OllamaMessage> messages = new ArrayList<>();
    private boolean stream = false;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<OllamaMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<OllamaMessage> messages) {
        this.messages = messages;
    }

    public boolean isStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public void addMessage(String role, String content) {
        this.messages.add(new OllamaMessage(role, content));
    }

    public static class OllamaMessage {
        private String role;
        private String content;

        public OllamaMessage() {
        }

        public OllamaMessage(String role, String content) {
            this.role = role;
            this.content = content;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
