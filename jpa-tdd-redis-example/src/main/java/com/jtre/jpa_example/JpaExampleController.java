package com.jtre.jpa_example;

import com.jtre.jpa_example.entity.BoardDto;
import com.jtre.jpa_example.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor //final 키워드를 사용하지 않으면 Bean 객체로 등록하지 않음.
public class JpaExampleController {
    private final JpaExampleService jpaExampleService;

    @GetMapping("/get-board-list")
    public List<BoardEntity> getAllPosts(){
        return   jpaExampleService.getPosts();
    }

    @PostMapping("/input-board-data")
    public BoardEntity inputBoarData(@RequestBody BoardDto boardDto){
        return jpaExampleService.createPost(boardDto);
    }
}
