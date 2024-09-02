package com.semiboard.Member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //Getter 는 private 메소드를 밖에서 꺼낼때 사용하는 메서드이다.
@NoArgsConstructor(access= AccessLevel.PROTECTED) //Access level setting
@Entity //객체형태 새성
@Table
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idx;

    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String reg_date;
}
