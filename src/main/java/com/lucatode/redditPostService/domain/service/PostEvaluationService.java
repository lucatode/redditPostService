package com.lucatode.redditPostService.domain.service;

import com.lucatode.redditPostService.domain.entity.Post;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostEvaluationService {

    Post evaluate(List<Post> list);
}
