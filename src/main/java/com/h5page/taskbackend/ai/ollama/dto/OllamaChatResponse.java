package com.h5page.taskbackend.ai.ollama.dto;

public class OllamaChatResponse {
    private OllamaMessage message;

    public OllamaMessage getMessage() {
        return message;
    }

    public void setMessage(OllamaMessage message) {
        this.message = message;
    }

    public String getMessageContent() {
        return message == null ? null : message.getContent();
    }

    public static class OllamaMessage {
        private String role;
        private String content;

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
