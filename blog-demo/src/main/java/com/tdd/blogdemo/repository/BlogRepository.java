package com.tdd.blogdemo.repository;

import com.tdd.blogdemo.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long>{
}
