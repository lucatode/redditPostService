package com.lucatode.redditPostService.domain.entity;

public class PostRequest {

    private final String category;
    private final String chatId;


    public PostRequest(String category, String chatId) {
        this.category = category;
        this.chatId = chatId;
    }

    public String getCategory() {
        return category;
    }

    public String getChatId() {
        return chatId;
    }

    private PostRequest(Builder builder) {
        category = builder.category;
        chatId = builder.chatId;
    }


    public static final class Builder {
        private String category;
        private String chatId;

        public Builder() {
        }

        public Builder withCategory(String val) {
            category = val;
            return this;
        }

        public Builder withChatId(String val) {
            chatId = val;
            return this;
        }

        public PostRequest build() {
            return new PostRequest(this);
        }
    }
}
