package com.quillverse.API.note;

import com.quillverse.API.note.notedto.NoteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Noteservice {
    // this is constarctor injection and happens when the notesercive bean itslef is created.
    private final NoteRepository noteRepository;// we didnt have to make it final if we want to but if it is final it becomes imutabale and that is a good practice
     private final DTOMapper dtoMapper;
    Noteservice(NoteRepository noteRepository, DTOMapper dtoMapper){
        this.noteRepository = noteRepository;
        this.dtoMapper=dtoMapper;
    }
    // our logic what we need to do with it.
    public List<Note> ListAll_Nots(){
        return noteRepository.findAll();
    }

    public List<NoteDto> listAlltoDTO(){
        return noteRepository.findAll().stream().map(dtoMapper::toNDto).collect(Collectors.toList());
    }
    public NoteDto createNewRec(NoteDto noteDto){
        Note newEntiity = dtoMapper.toNote(noteDto);
        Note savedEntity = noteRepository.save(newEntiity);// this will perist whaat we try to save on the data base;
        return dtoMapper.toNDto(savedEntity);


    }

}
