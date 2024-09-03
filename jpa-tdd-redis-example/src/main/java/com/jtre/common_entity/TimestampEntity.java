package com.jtre.common_entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
/*
* @MappedSuperclass
*  - 테이블에 생성되지 않고, 상속받을 테이블에 반영이 된다.
*  - 해당 클래스를 상속받게 되면 마치 내부에서 선언 한듯이 사용할 수 있게 된다.
*  - 코드의 중복을 줄이니, 유지보수에 용이하다.
*  - 필드와 메서드를 상속받을 수 있도록 하는 추상 클래스나 상위 클래스를 정의
* */
@EntityListeners(AuditingEntityListener.class)
public class TimestampEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
