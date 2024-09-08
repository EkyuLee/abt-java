package com.prjf17.springjava17.repository;

import com.prjf17.springjava17.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
