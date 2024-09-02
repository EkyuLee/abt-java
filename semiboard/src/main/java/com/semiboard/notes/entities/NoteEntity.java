package com.semiboard.notes.entities;

import com.semiboard.notes.dtos.NoteRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class NoteEntity extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public NoteEntity(String username, String contents) {
        this.username = username;
        this.contents = contents;
    }

    public NoteEntity(NoteRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    //constructor가 아니기 때문에 타입을 기입해줘야 한다.
    public void update(NoteRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
