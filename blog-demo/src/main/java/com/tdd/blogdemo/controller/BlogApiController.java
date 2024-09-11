package com.tdd.blogdemo.controller;

import com.tdd.blogdemo.domain.Article;
import com.tdd.blogdemo.dto.AddArticleRequest;
import com.tdd.blogdemo.dto.ArticleResponse;
import com.tdd.blogdemo.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor //final 을 사용하면 생성자 호출 없이 사용 가능 ( NEW ** <- 생략)
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){ //ResponseEntity <- 객체 응답 클래스
        Article saveArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveArticle);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable Long id){
        Article article = blogService.findById(id);
        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<Article>> getAllArticles(){
        List<Article> result = blogService.findAll();
        return ResponseEntity.ok().body(result);
    }
}
