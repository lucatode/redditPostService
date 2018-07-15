package com.lucatode.redditPostService.domain.usecase;

import com.lucatode.redditPostService.domain.entity.Post;
import com.lucatode.redditPostService.domain.entity.PostRequest;
import com.lucatode.redditPostService.domain.repository.ErogationRepository;
import com.lucatode.redditPostService.domain.repository.PostRepository;

public class PostErogationUseCase {

    private final ErogationRepository erogationRepository;
    private final PostRepository postRepository;

    public PostErogationUseCase(ErogationRepository erogationRepository, PostRepository postRepository) {
        this.erogationRepository = erogationRepository;
        this.postRepository = postRepository;
    }

    public Post getPost(PostRequest request) {

       return erogationRepository.getErogatedPosts(request).stream().findFirst().get();
    }
}
