package com.quillverse.API.note;

import com.quillverse.API.note.notedto.NoteDto;
import org.springframework.stereotype.Component;

@Component
public class DTOMapper {

    public NoteDto toNDto(Note note){
        if (note == null){
            return null;
        }

        return new NoteDto (
                note.getId(),
                note.getName(),
                note.getContent()
        );

    }

    public Note toNote(NoteDto noteDto){
        if (noteDto == null){
            return null;
        }

        return new Note(noteDto.getName(),noteDto.getContent());
    }


}
