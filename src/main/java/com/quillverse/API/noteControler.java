package com.quillverse.API;

import com.quillverse.API.note.Noteservice;
import com.quillverse.API.note.notedto.NoteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("//api/allnotes")// we obviosly now can put the requisst in this so the post an gett work easily
public class noteControler {
    @Autowired
    private Noteservice noteservice;
    @GetMapping()
    public List<NoteDto> gettallnots(){
        return noteservice.listAlltoDTO();
    }
    @PostMapping
    public ResponseEntity<NoteDto> saveNote(@RequestBody NoteDto noteDto){
        NoteDto savedNote = noteservice.createNewRec(noteDto);
        return new ResponseEntity<>(noteDto,HttpStatus.CREATED);
    }

}
