package com.quillverse.API.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Noteservice {
    // this is constarctor injection and happens when the notesercive bean itslef is created.
    @Autowired
    private final NoteRepository noteRepository;// we didnt have to make it final if we want to but if it is final it becomes imutabale and that is a good practice

    Noteservice(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }
    // our logic what we need to do with it.
    public List<Note> ListAll_Nots(){
        return noteRepository.findAll();
    }

}
