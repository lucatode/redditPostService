package com.lucatode.redditPostService.domain.repository;

import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.lucatode.redditPostService.domain.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostRepository {
    List<Post> getNonErogatedPosts(List<ErogatedPost> erogatedPosts);
}

