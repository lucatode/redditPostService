package com.lucatode.redditPostService.domain.usecase;

import com.lucatode.redditPostService.adapter.mongodb.MongoDbClient;
import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.lucatode.redditPostService.domain.entity.Post;
import com.lucatode.redditPostService.domain.entity.PostRequest;
import com.lucatode.redditPostService.domain.repository.ErogationRepository;
import com.lucatode.redditPostService.domain.repository.PostRepository;
import com.lucatode.redditPostService.domain.service.PostEvaluationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostErogationUseCaseTest {

    PostErogationUseCase postErogationUseCase;

    @Mock
    ErogationRepository erogationRepository;
    @Mock
    PostRepository postRepository;
    @Mock
    PostEvaluationService postEvaluationService;


    @Before
    public void setUp(){
        postErogationUseCase = new PostErogationUseCase(erogationRepository, postRepository,postEvaluationService);
    }

    @Test
    public void getANonAlreadyErogatedPost(){
        List<ErogatedPost> erogatedPosts = getErogatedPosts();
        PostRequest request = new PostRequest.Builder().withCategory("gif").withChatId("123456").build();
        when(erogationRepository.getErogatedPosts(any())).thenReturn(erogatedPosts);
        List<Post> posts = getPosts();
        when(postRepository.getNonErogatedPosts(erogatedPosts)).thenReturn(posts);

        Post post = postErogationUseCase.getPost(request);

        Assert.assertNotNull(post);
        verify(erogationRepository).getErogatedPosts(request);
        verify(postRepository).getNonErogatedPosts(erogatedPosts);
    }

    private List<Post> getPosts() {
        return Arrays.asList(
                new Post.PostBuilder().build());
    }

    private List<ErogatedPost> getErogatedPosts() {
        return Arrays.asList(
            new ErogatedPost.Builder().withPostId("123").withChatId("ABC").build(),
            new ErogatedPost.Builder().withPostId("456").withChatId("ABC").build()
        );
    }


}