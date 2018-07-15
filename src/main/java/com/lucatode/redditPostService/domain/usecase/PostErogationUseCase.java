package com.lucatode.redditPostService.domain.usecase;

import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.lucatode.redditPostService.domain.entity.Post;
import com.lucatode.redditPostService.domain.entity.PostRequest;
import com.lucatode.redditPostService.domain.repository.ErogationRepository;
import com.lucatode.redditPostService.domain.repository.PostRepository;

import java.util.List;

public class PostErogationUseCase {

    private final ErogationRepository erogationRepository;
    private final PostRepository postRepository;

    public PostErogationUseCase(ErogationRepository erogationRepository, PostRepository postRepository) {
        this.erogationRepository = erogationRepository;
        this.postRepository = postRepository;
    }

    public Post getPost(PostRequest request) {

        List<ErogatedPost> erogatedPosts = erogationRepository.getErogatedPosts(request);
        List<Post> nonErogatedPosts = postRepository.getNonErogatedPosts(erogatedPosts);

        return nonErogatedPosts.stream().findFirst().get();
    }
}
