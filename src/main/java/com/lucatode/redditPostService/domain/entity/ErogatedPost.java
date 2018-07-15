package com.lucatode.redditPostService.domain.entity;

public class ErogatedPost {

    public final String chatId;
    public final String postId;


    public ErogatedPost(String chatId, String postId) {
        this.chatId = chatId;
        this.postId = postId;
    }

    private ErogatedPost(Builder builder) {
        chatId = builder.chatId;
        postId = builder.postId;
    }

    public String getChatId() {
        return chatId;
    }

    public String getPostId() {
        return postId;
    }

    public static final class Builder {
        private String chatId;
        private String postId;

        public Builder() {
        }

        public Builder withChatId(String val) {
            chatId = val;
            return this;
        }

        public Builder withPostId(String val) {
            postId = val;
            return this;
        }

        public ErogatedPost build() {
            return new ErogatedPost(this);
        }
    }
}
