package com.lucatode.redditPostService.domain.service;

import com.lucatode.redditPostService.domain.entity.Post;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ToErogateEvaluationServiceTest {

    public static final String POST_ID = "abc";
    ToErogateEvaluationService underTest;

    @Before
    public void setUp() throws Exception {

        underTest = new ToErogateEvaluationService();
    }

    @Test
    public void evaluateAsinglePostList() {

        List<Post> list = Arrays.asList(new Post.PostBuilder().withId(POST_ID).build());
        Post candidate = underTest.evaluate(list);

        assertThat(candidate.getId(), is(POST_ID));
    }



}