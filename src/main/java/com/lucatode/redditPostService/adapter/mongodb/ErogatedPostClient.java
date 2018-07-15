package com.lucatode.redditPostService.adapter.mongodb;

import com.lucatode.redditPostService.adapter.mongodb.entity.ErogatedPostBson;
import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ErogatedPostClient implements MongoDbClient<ErogatedPost> {

    private String connectionString;
    private String collectionName;

    private final MongoClient mongoClient;

    public ErogatedPostClient() {
        Map<String, String> env = System.getenv();
        connectionString = env.get("CONNECTION_STRING");
        collectionName = env.get("COLLECTION_NAME_EROGATED");
        MongoClientURI uri = new MongoClientURI(connectionString);
        mongoClient = new MongoClient(uri);
    }

    @Override
    public List<ErogatedPost> getRecords() {
        MongoDatabase database = mongoClient.getDatabase("funfacts");
        MongoCollection<Document> collection = database.getCollection(collectionName);
        MongoCursor<Document> cursor = collection.find().iterator();
        List<ErogatedPost> list = new ArrayList<>();

        try {
            while (cursor.hasNext()) {
                final ErogatedPostBson erogatedPost = new ErogatedPostBson.Builder().fromDocument(cursor.next()).build();
                list.add(erogatedPost.toErogatedPost());
            }
        } finally {
            cursor.close();
        }

        return list;
    }

    @Override
    public void put(ErogatedPost record) {
        MongoDatabase database = mongoClient.getDatabase("funfacts");
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(new ErogatedPostBson.Builder().withChatId(record.getChatId()).withPostId(record.getPostId()).build().toDocument());
    }
}
