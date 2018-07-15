package com.lucatode.redditPostService.domain.repository;

import com.lucatode.redditPostService.domain.entity.Post;

import java.util.List;

public interface PostRepository {
    List<Post> GetPosts();

    Post getPostById(String id);

    void pushPost(Post post);
}

