package com.hillel.news_rest_client.controller;

import com.hillel.news_rest_client.service.RestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/news")
public class RestClientController {

    private final RestClientService restClientService;

    public RestClientController(RestClientService restClientService) {
        this.restClientService = restClientService;
    }

    @GetMapping("/topNews")
    public Map getTopHeadlines() {
        return restClientService.callTopNews();
    }

    @GetMapping("/allNews")
    public Map getEverything() {
        return restClientService.callAllNews();
    }


}
