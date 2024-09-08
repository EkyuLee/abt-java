package com.prjf17.springjava17.service;

import com.prjf17.springjava17.domain.Article;
import com.prjf17.springjava17.dto.AddArticleRequest;
import com.prjf17.springjava17.dto.ArticleResponse;
import com.prjf17.springjava17.dto.UpdateArticleRequest;
import com.prjf17.springjava17.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나, @NotNull이 붙은 필드의 생성자를 추가한다.
@Service //Bean으로 서블릿 컨테이너에 등록한다.
public class BlogService {
    private final BlogRepository blogRepository;

    // insert method
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity()); //JpaRepository에서 blogRepository 로 save를 상속받아서 사용.
    }

    // select method
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    // select using id
    public Article findById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found" + id));
    }

    //delete using id
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    //update
    @Transactional //중간에 이슈가 발생해도 제대로된 수정 값을 보장할 수 있도록 선언해주어야 함.
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id) //repository에서 id를 이용하여 조회를한다.
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        article.update(request.getTitle(), request.getContent()); // 조회된 내용의 entity를 업데이트 한다.
        return article;
    }

}
