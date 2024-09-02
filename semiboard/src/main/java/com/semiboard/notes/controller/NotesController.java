package com.semiboard.notes.controller;

import com.semiboard.notes.dtos.NoteRequestDto;
import com.semiboard.notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.semiboard.notes.entities.NoteEntity;
import java.util.List;

/*
 * 1. entity 생성 - 데이터 형태 지정 부
 * 2. repository 생성 <메모가 list 형태이므로 list형태의 entity 를 저장>
 * 3. Service 생성 - repository에 접근하여 저장, 수정, 삭제, 조회 진행
 * 4. Controller 생성 - 명령 수신 부
 * 5. DTO 생성, 데이터를 body로 수신 받기 위함.
 * */

@RestController
@RequiredArgsConstructor // 새로운 생성자를 호출할때 번거로움을 없애준다.
@RequestMapping("/notes")
public class NotesController {
    private final NoteService noteService;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("note_index");
    }

    @PostMapping("/api/notes")
    public NoteEntity createNotes(@RequestBody NoteRequestDto requestDto){ // create to db
        return noteService.createNote(requestDto);
    }

    @GetMapping("/api/notes")
    public List<NoteEntity> getAllNotes(){
        return noteService.getNotes();
    }

    @PutMapping("/api/notes/{id}")
    public Long updateNote(@PathVariable Long id, @RequestBody NoteRequestDto requestDto){
        return noteService.updateNote(id, requestDto);
    }

    @DeleteMapping("/api/notes/{id}")
    public Long deleteNote(@PathVariable Long id){
        return noteService.deleteNote(id);
    }

}
