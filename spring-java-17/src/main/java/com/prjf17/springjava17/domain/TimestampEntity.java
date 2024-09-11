package com.prjf17.springjava17.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass //해당 엔티티는 프로그램 빌드와 동시에 테이블 생성이 되는것이 아닌, 상속자로 써 역할을 할 수 있는 엔티티로 사용하기 위함이다.
@EntityListeners(AuditingEntityListener.class)
public class TimestampEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}