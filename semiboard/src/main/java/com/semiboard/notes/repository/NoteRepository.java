package com.semiboard.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.semiboard.notes.entities.NoteEntity;

import java.util.List;

public interface NoteRepository extends JpaRepository<NoteEntity, Long>{
    List<NoteEntity> findAllByOrderByModifiedAtDesc();
}
