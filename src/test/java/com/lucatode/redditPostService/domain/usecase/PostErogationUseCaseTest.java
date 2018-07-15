package com.lucatode.redditPostService.domain.usecase;

import com.lucatode.redditPostService.domain.entity.Post;
import com.lucatode.redditPostService.domain.entity.PostRequest;
import com.lucatode.redditPostService.domain.repository.ErogationRepository;
import com.lucatode.redditPostService.domain.repository.PostRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostErogationUseCaseTest {

    @Mock
    ErogationRepository erogationRepository;
    @Mock
    PostRepository postRepository;


    @Test
    public void getAPost(){
        PostErogationUseCase postErogationUseCase = new PostErogationUseCase(erogationRepository,postRepository);
        when(erogationRepository.getErogatedPosts(any())).thenReturn(Arrays.asList(new Post.PostBuilder().build()));

        PostRequest request = new PostRequest.Builder().withCategory("gif").withChatId("123456").build();
        Post post = postErogationUseCase.getPost(request);

        Assert.assertNotNull(post);
        verify(erogationRepository).getErogatedPosts(request);
    }
}