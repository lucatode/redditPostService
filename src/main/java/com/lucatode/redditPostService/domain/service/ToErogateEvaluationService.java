package com.lucatode.redditPostService.domain.service;

import com.lucatode.redditPostService.domain.entity.Post;

import java.util.List;

public class ToErogateEvaluationService implements PostEvaluationService {

    @Override
    public Post evaluate(List<Post> list) {
        return list.stream().findFirst().get();
    }
}
