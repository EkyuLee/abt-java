package com.prjf17.springjava17.test;

import jakarta.persistence.*;

// lombok dependencies가 제대로 추가 되었는지 확인해보기 위한 코드
@Entity
public class Member2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // 기본 생성자 (JPA에서 필요)
    public Member2() {
    }

    // 모든 필드를 받는 생성자
    public Member2(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
