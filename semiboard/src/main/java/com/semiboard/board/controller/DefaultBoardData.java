package com.semiboard.board.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter //get setting
@Setter //set setting
@AllArgsConstructor //클래스의 모든 필드 값을 파라미터로 받는 생성자를 자동으로 생성
public class DefaultBoardData {
    private String title;
    private String content;
    private String datetime;
}
