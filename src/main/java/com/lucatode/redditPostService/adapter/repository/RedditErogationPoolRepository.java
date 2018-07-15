package com.lucatode.redditPostService.adapter.repository;

import com.lucatode.redditPostService.adapter.mongodb.MongoDbClient;
import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.lucatode.redditPostService.domain.entity.PostRequest;
import com.lucatode.redditPostService.domain.repository.ErogationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RedditErogationPoolRepository implements ErogationRepository {

    private final MongoDbClient<ErogatedPost> erogatedPostMongoDbClient;

    @Autowired
    public RedditErogationPoolRepository(MongoDbClient<ErogatedPost> erogatedPostMongoDbClient) {

        this.erogatedPostMongoDbClient = erogatedPostMongoDbClient;
    }

    @Override
    public List<ErogatedPost> getErogatedPosts(PostRequest postRequest) {
        return erogatedPostMongoDbClient.getRecords().stream().filter(p-> p.getChatId() != postRequest.getChatId()).collect(Collectors.toList());
    }
}
