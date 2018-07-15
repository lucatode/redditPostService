package com.lucatode.redditPostService.controller;

import com.lucatode.redditPostService.domain.entity.PostRequest;
import com.lucatode.redditPostService.domain.usecase.PostErogationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedditPostController {

    private final PostErogationUseCase postErogationUseCase;

    @Autowired
    public RedditPostController(PostErogationUseCase postErogationUseCase) {

        this.postErogationUseCase = postErogationUseCase;
    }

    @GetMapping("/redditPost/{category}/{chatId}")
    public @ResponseBody
    String redditPost(@PathVariable String category, @PathVariable String chatId) {

        return this.postErogationUseCase.getPost(new PostRequest.Builder().withCategory(category).withChatId(chatId).build()).toString();
    }

}
