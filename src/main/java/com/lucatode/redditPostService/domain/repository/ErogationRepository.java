package com.lucatode.redditPostService.domain.repository;

import com.lucatode.redditPostService.domain.entity.Post;
import com.lucatode.redditPostService.domain.entity.PostRequest;

import java.util.List;

public interface ErogationRepository {

    List<Post> getErogatedPosts(PostRequest postRequest);
 }
