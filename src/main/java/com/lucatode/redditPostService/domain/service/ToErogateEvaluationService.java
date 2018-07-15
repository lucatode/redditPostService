package com.lucatode.redditPostService.domain.service;

import com.lucatode.redditPostService.domain.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToErogateEvaluationService implements PostEvaluationService {

    public ToErogateEvaluationService() {
    }

    @Override
    public Post evaluate(List<Post> list) {
        return list.stream().findFirst().get();
    }
}
