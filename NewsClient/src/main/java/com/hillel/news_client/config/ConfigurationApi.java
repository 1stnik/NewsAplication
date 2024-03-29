package com.hillel.news_client.config;


import com.hillel.news_client.service.NewsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationApi {

    @Bean
    public NewsService newsApiService() {
        return new NewsService();
    }

}
