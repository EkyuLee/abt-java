package com.jtre.jpa_example;

import com.jtre.jpa_example.entity.BoardDto;
import com.jtre.jpa_example.entity.BoardEntity;
import com.jtre.jpa_example.JpaExampleRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // 생성자를 호출없이 바로 사용할 수 있도록 도와줌.
public class JpaExampleService {
    private final JpaExampleRepository jpaExampleRepository;

    @Transactional(readOnly = true)
    public List<BoardEntity> getPosts(){
        return jpaExampleRepository.findAllByOrderByLastModifiedDateDesc();
    }

    @Transactional
    public BoardEntity createPost(BoardDto boardDto){
        BoardEntity board = new BoardEntity(boardDto);
        jpaExampleRepository.save(board);
        return board;
    }

    @Transactional
    public String createPost2(){

        BoardEntity board = new BoardEntity("1", "2");
        System.out.println(board.getBoard_content());
        //jpaExampleRepository.save(board);
        return board.getBoard_content();
    }
}
