package com.lucatode.redditPostService.domain.service;

import com.lucatode.redditPostService.domain.entity.Post;

import java.util.List;

public interface PostEvaluationService {

    Post evaluate(List<Post> list);
}
