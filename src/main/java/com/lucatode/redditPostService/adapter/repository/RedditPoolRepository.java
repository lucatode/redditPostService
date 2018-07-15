package com.lucatode.redditPostService.adapter.repository;

import com.lucatode.redditPostService.adapter.mongodb.MongoDbClient;
import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.lucatode.redditPostService.domain.entity.Post;
import com.lucatode.redditPostService.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RedditPoolRepository implements PostRepository {

    private final MongoDbClient<Post> postMongoDbClient;

    @Autowired
    public RedditPoolRepository(MongoDbClient<Post> postMongoDbClient) {
        this.postMongoDbClient = postMongoDbClient;
    }

    @Override
    public List<Post> getNonErogatedPosts(List<ErogatedPost> erogatedPosts) {

        List<String> erogatedIds = erogatedPosts.stream().map(e -> e.getPostId()).collect(Collectors.toList());

        return postMongoDbClient.getRecords().stream().filter(post -> !erogatedIds.contains(post.getId())).collect(Collectors.toList());
    }
}
