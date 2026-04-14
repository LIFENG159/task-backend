package com.h5page.taskbackend.ai.openai.dto;

import java.util.List;

public class OpenAiChatResponse {
    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public String getFirstMessageContent() {
        if (choices == null || choices.isEmpty()) {
            return null;
        }
        Choice choice = choices.get(0);
        if (choice == null || choice.message == null) {
            return null;
        }
        return choice.message.getContent();
    }

    public static class Choice {
        private OpenAiMessage message;

        public OpenAiMessage getMessage() {
            return message;
        }

        public void setMessage(OpenAiMessage message) {
            this.message = message;
        }
    }

    public static class OpenAiMessage {
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
