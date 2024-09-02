package com.semiboard.notes.service;

import com.semiboard.notes.dtos.NoteRequestDto;
import com.semiboard.notes.entities.NoteEntity;
import com.semiboard.notes.repository.NoteRepository;


import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    @Transactional //create note service
    public NoteEntity createNote(NoteRequestDto requestDto){
        NoteEntity note = new NoteEntity(requestDto);
        noteRepository.save(note);
        return note;
    }

    @Transactional(readOnly = true)
    public List<NoteEntity> getNotes(){ //get notes
        return noteRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional //update .. !
    public Long updateNote(long id, NoteRequestDto requestDto){
        NoteEntity notes = noteRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("CAN NOT FIND ID")
        );
        notes.update(requestDto);
        return notes.getId();
    }

    @Transactional //delete
    public Long deleteNote(Long id){
        noteRepository.deleteById(id);
        return id;
    }
}