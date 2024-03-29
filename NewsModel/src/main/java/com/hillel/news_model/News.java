package com.hillel.news_model;

public class News {

    private String title;
    private String author;
    private String description;
    private String url;

    public News(String title) {
        this.title = title;
    }

    public News(String title, String author, String description, String url) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "News {" +
                "Title: '" + title + '\'' +
                ", Author: '" + author + '\'' +
                ", Description: '" + description + '\'' +
                ", URL: '" + url + '\'' +
                '}';
    }
}
