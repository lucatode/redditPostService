package com.lucatode.redditPostService.adapter.mongodb;

import com.lucatode.redditPostService.adapter.mongodb.entity.ErogatedPostBson;
import com.lucatode.redditPostService.adapter.mongodb.entity.PostBson;
import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.lucatode.redditPostService.domain.entity.Post;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PostPoolClient implements MongoDbClient<Post> {
    private String connectionString;
    private String collectionName;

    private final MongoClient mongoClient;

    public PostPoolClient() {
        Map<String, String> env = System.getenv();
        connectionString = env.get("CONNECTION_STRING");
        collectionName = env.get("COLLECTION_NAME_POOL");
        MongoClientURI uri = new MongoClientURI(connectionString);
        mongoClient = new MongoClient(uri);
    }

    @Override
    public List<Post> getRecords() {
        MongoDatabase database = mongoClient.getDatabase("funfacts");
        MongoCollection<Document> collection = database.getCollection(collectionName);
        MongoCursor<Document> cursor = collection.find().iterator();
        List<Post> list = new ArrayList<>();

        try { 
            while (cursor.hasNext()) {
                final PostBson erogatedPost = new PostBson.PostBsonBuilder().fromDocument(cursor.next()).build();
                list.add(erogatedPost.toPost());
            }
        } finally {
            cursor.close();
        }

        return list;
    }
}
