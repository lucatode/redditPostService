package com.lucatode.redditPostService.adapter.mongodb.entity;

import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Date;

public class ErogatedPostBson {
    @BsonProperty("chatId")
    private String chatId;
    @BsonProperty("postId")
    private String postId;

    @BsonCreator
    public ErogatedPostBson() {
    }

    public ErogatedPost toErogatedPost() {
        return new ErogatedPost.Builder()
                .withChatId(chatId)
                .withPostId(postId)
                .build();
    }

    private ErogatedPostBson(Builder builder) {
        chatId = builder.chatId;
        postId = builder.postId;
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

        public Builder fromDocument(Document doc) {
            this.chatId = (String) doc.get("chatId");
            this.postId = (String) doc.get("postId");
            return this;
        }

        public ErogatedPostBson build() {
            return new ErogatedPostBson(this);
        }
    }
}
