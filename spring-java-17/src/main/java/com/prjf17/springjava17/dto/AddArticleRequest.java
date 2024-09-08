package com.prjf17.springjava17.dto;

import com.prjf17.springjava17.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라이터로 받는 생성자 추가
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(){ // builder 패턴을 사용하여 DTO 를 entity로 만들어주는 메서드 이다.
        return Article.builder().title(title).content(content).build();
    }
}
