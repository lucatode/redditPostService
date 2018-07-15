package com.lucatode.redditPostService.adapter.mongodb;

import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import com.lucatode.redditPostService.domain.entity.Post;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PostPoolClientTest {

    private PostPoolClient classUnderTest;

    @Before
    public void setUp() throws Exception {
        Map<String, String> env = System.getenv();
        String CONNECTION_STRING = env.get("CONNECTION_STRING");
        String COLLECTION_NAME = env.get("COLLECTION_NAME");

        classUnderTest = new PostPoolClient();
    }

    @Test
    public void getRecordsIT() {
        List<Post> records = classUnderTest.getRecords();
        assertThat(records.size(), is(1));
    }
}