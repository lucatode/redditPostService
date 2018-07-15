package com.lucatode.redditPostService.domain.repository;

import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.lucatode.redditPostService.domain.entity.Post;
import com.lucatode.redditPostService.domain.entity.PostRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ErogationRepository {

    List<ErogatedPost> getErogatedPosts(PostRequest postRequest);

    void save(String postId, String chatId);
}
