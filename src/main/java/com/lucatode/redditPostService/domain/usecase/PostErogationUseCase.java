package com.lucatode.redditPostService.domain.usecase;

import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.lucatode.redditPostService.domain.entity.Post;
import com.lucatode.redditPostService.domain.entity.PostRequest;
import com.lucatode.redditPostService.domain.repository.ErogationRepository;
import com.lucatode.redditPostService.domain.repository.PostRepository;
import com.lucatode.redditPostService.domain.service.PostEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostErogationUseCase {

    private final ErogationRepository erogationRepository;
    private final PostRepository postRepository;
    private final PostEvaluationService postEvaluationService;

    @Autowired
    public PostErogationUseCase(
            ErogationRepository erogationRepository,
            PostRepository postRepository,
            PostEvaluationService postEvaluationService) {
        this.erogationRepository = erogationRepository;
        this.postRepository = postRepository;
        this.postEvaluationService = postEvaluationService;
    }

    public Post getPost(PostRequest request) {

        List<ErogatedPost> erogatedPosts = erogationRepository.getErogatedPosts(request);
        List<Post> nonErogatedPosts = postRepository.getNonErogatedPosts(erogatedPosts);

        //TODO: add logic here
        Post candidate = postEvaluationService.evaluate(nonErogatedPosts);

        //TODO: save erogated post
        erogationRepository.save(candidate.getId(), request.getChatId());

        return candidate;
    }
}
