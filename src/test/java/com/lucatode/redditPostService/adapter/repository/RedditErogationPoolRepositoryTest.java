package com.lucatode.redditPostService.adapter.repository;

import com.lucatode.redditPostService.adapter.mongodb.MongoDbClient;
import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.lucatode.redditPostService.domain.entity.PostRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RedditErogationPoolRepositoryTest {

    RedditErogationPoolRepository classUnderTest;

    @Mock
    MongoDbClient<ErogatedPost> erogatedPostMongoDbClient;

    @Before
    public void setUp(){
        classUnderTest = new RedditErogationPoolRepository(erogatedPostMongoDbClient);
        List<ErogatedPost> retrievedErogatedPosts = getRetrievedErogatedPosts();
        when(erogatedPostMongoDbClient.getRecords()).thenReturn(retrievedErogatedPosts);
    }

    @Test
    public void getNoErogatedPosts() {
        List<ErogatedPost> erogatedPosts = classUnderTest.getErogatedPosts(new PostRequest.Builder().build());
        Assert.assertNotNull(erogatedPosts);
    }

    @Test
    public void getSingleErogatedPost(){
        List<ErogatedPost> erogatedPosts = classUnderTest.getErogatedPosts(new PostRequest.Builder().withChatId("ABC").withCategory("gif").build());

        Assert.assertNotNull(erogatedPosts);
        verify(erogatedPostMongoDbClient).getRecords();
        assertThat(erogatedPosts.size(), is(1));
        assertThat(erogatedPosts.stream().findFirst().get().getPostId(), is("123"));
    }

    private List<ErogatedPost> getRetrievedErogatedPosts() {
        return Arrays.asList(
                new ErogatedPost.Builder().withChatId("ABC").withPostId("123").build(),
                new ErogatedPost.Builder().withChatId("DEF").withPostId("123").build()
        );
    }
}