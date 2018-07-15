package com.lucatode.redditPostService.adapter.mongodb;

import com.lucatode.redditPostService.domain.entity.ErogatedPost;

import java.util.List;

public interface MongoDbClient<OUTPUT> {

    List<OUTPUT> getRecords();

    void put(OUTPUT record);
}
