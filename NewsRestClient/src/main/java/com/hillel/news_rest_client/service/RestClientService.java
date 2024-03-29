package com.hillel.news_rest_client.service;

import com.hillel.news_model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RestClientService {

    @Autowired
    private RestTemplate restTemplate;

    public Map<Integer, News> callTopNews() {

        return (Map<Integer, News>) restTemplate.getForEntity("http://localhost:8080/news/top-headlines", Map.class)
                .getBody();

    }

    public Map<Integer, News> callAllNews() {

        return (Map<Integer, News>) restTemplate.getForEntity("http://localhost:8080/news/everything", Map.class)
                .getBody();

    }

}
