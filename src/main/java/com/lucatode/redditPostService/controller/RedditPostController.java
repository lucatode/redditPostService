package com.lucatode.redditPostService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedditPostController {

        @GetMapping("/redditPost/{category}/{chatId}")
        public @ResponseBody
        String redditPost(@PathVariable String category, @PathVariable String chatId) {
            return "get a post of type "+category+" for chat id "+chatId;
        }

    }
