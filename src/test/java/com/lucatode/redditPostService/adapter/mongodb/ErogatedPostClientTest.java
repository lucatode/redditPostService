package com.lucatode.redditPostService.adapter.mongodb;

import com.lucatode.redditPostService.domain.entity.ErogatedPost;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ErogatedPostClientTest {

    private ErogatedPostClient classUnderTest;

    @Before
    public void setUp() throws Exception {
        Map<String, String> env = System.getenv();
        String CONNECTION_STRING = env.get("CONNECTION_STRING");
        String COLLECTION_NAME = env.get("COLLECTION_NAME");

        classUnderTest = new ErogatedPostClient();
    }

    @Test
    public void getRecordsIT() {
        List<ErogatedPost> records = classUnderTest.getRecords();
        assertThat(records.size(), is(0));
    }

    @After
    public void tearDown() throws Exception {
    }

}