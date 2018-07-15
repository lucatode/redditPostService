package com.lucatode.redditPostService.adapter.mongodb;

import java.util.List;

public interface MongoDbClient<OUTPUT> {

    List<OUTPUT> getRecords();

}
