package com.hillel.news_client.service;

import com.hillel.news_model.News;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NewsService {

    private static final String API_KEY = System.getenv("API_KEY"); // Замените YOUR_API_KEY на ваш API ключ

    Map<Integer, News> topOfNews = new HashMap<>();
    Map<Integer, News> allOfNews = new HashMap<>();


    public Map<Integer, News> getTopHeadlines() {
        NewsApiClient newsApiClient = new NewsApiClient(API_KEY);
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q("War")
                        .language("en")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        for (int i = 0; i < response.getArticles().size(); i++) {
                            // We can add "Glory to Ukraine" here or in the Rest Client Service.
                            topOfNews.put(i, new News("Glory to Ukraine: " +
                                    response.getArticles().get(i).getTitle(),
                                    response.getArticles().get(i).getAuthor(),
                                    response.getArticles().get(i).getDescription(),
                                    response.getArticles().get(i).getUrl()));
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
        for (int i = 0; i < topOfNews.size(); i++) {
            System.out.println(topOfNews.get(i).getTitle());
        }
        return topOfNews;
    }

    public Map<Integer, News> getEverything() {
        NewsApiClient newsApiClient = new NewsApiClient(API_KEY);
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("Ukraine")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        for (int i = 0; i < response.getArticles().size(); i++) {
                            // We can add "Glory to Ukraine" here or in the Rest Client Service.
                            News news = new News("Glory to Ukraine: " +
                                    response.getArticles().get(i).getTitle(),
                                    response.getArticles().get(i).getAuthor(),
                                    response.getArticles().get(i).getDescription(),
                                    response.getArticles().get(i).getUrl());
                            allOfNews.put(i, news);
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
        for (int i = 0; i < allOfNews.size(); i++) {
            System.out.println(allOfNews.get(i));
        }
        return allOfNews;
    }
}
