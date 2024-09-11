package com.tdd.blogdemo.dto;

import com.tdd.blogdemo.domain.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleResponse {
    private String title;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedDate;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdTime = article.getCreatedDate();
        this.lastModifiedDate = article.getLastModifiedDate();
    }
}
