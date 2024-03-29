package com.hillel.news_client.controller;

import com.hillel.news_model.News;
import com.hillel.news_client.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/top-headlines")
    public Map<Integer, News> getTopHeadlines() {
        return newsService.getTopHeadlines();
    }

    @GetMapping("/everything")
    public Map<Integer, News> getEverything() {
        return newsService.getEverything();
    }
}