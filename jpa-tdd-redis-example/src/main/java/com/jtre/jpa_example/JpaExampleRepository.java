package com.jtre.jpa_example;

import com.jtre.jpa_example.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JpaExampleRepository extends JpaRepository<BoardEntity, Long> {
    List<BoardEntity> findAllByOrderByLastModifiedDateDesc();
}
//lastModifiedDate