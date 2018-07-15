package com.lucatode.redditPostService.domain.repository;

import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.lucatode.redditPostService.domain.entity.PostRequest;

import java.util.List;

public interface ErogationRepository {

    List<ErogatedPost> getErogatedPosts(PostRequest postRequest);
 }
