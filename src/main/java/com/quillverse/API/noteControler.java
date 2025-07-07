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
    // this is how the reqist will propaget?
    @GetMapping("/{id}")
    // look here the @path varible creates align betwing the long id and the id in the get mapping , this mean the Long id could be name any thing as logn the name in the path variable and the get maping
    //much
    public ResponseEntity<NoteDto> getNoteById(@PathVariable("id") Long id){
        return ResponseEntity.ok(noteservice.findNoteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDto> updateNote(@PathVariable ("id") Long id, @RequestBody NoteDto noteDto){
        return ResponseEntity.ok(noteservice.updateNote(id, noteDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletNote(@PathVariable("id") Long id){
        noteservice.deletNote(id);
        // i will have to understand this more
        return ResponseEntity.noContent().build();
    }

}
