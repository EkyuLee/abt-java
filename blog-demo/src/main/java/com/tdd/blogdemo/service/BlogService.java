package com.tdd.blogdemo.service;

import com.tdd.blogdemo.domain.Article;
import com.tdd.blogdemo.dto.AddArticleRequest;
import com.tdd.blogdemo.dto.ArticleResponse;
import com.tdd.blogdemo.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public Article findById(Long id){
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found id : " + id));
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }
}
