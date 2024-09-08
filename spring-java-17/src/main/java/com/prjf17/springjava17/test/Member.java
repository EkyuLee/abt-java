package com.prjf17.springjava17.test;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor//(access = AccessLevel.PRIVATE ) // 기본 생성자
@Getter
@Entity //Entity로 지정, name을 지정하지 않았기 때문에 member라는 테이블을 그대로 매핑함.
//@Entity(name = "members") 를 하면 members 테이블을 매핑한다.
public class Member {
    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가, IDENTITY = AUTO_INCREMENT
    private Long id;

    @Column(name = "name", nullable = false) // name이라는 not null 컬럼과 매핑
    private String name;
}
