package com.jtre.jpa_example.entity;

import com.jtre.common_entity.TImestampEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class BoardEntity extends TImestampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long board_idx;

    @Column(nullable = false)
    private String board_title;

    @Column(nullable = false)
    private String board_content;

    //input value using BoardEntity constructor
    public BoardEntity(String board_title, String board_content) {
        this.board_title = board_title;
        this.board_content = board_content;
    }

    //input value using DTO
    public BoardEntity(BoardDto boardDto) {
        this.board_title = boardDto.getBoard_title();
        this.board_content = boardDto.getBoard_content();
    }


}
