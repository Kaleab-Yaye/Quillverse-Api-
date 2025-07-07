package com.quillverse.API.note;

import com.quillverse.API.note.notedto.NoteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public NoteDto findNoteById(Long id){
        // you should alway know the findByID class always return an optional object.
        Optional <Note> noteOptional = noteRepository.findById(id);
        //we will be thougign an expetion on our own
        if(noteOptional.isEmpty()){
            throw new RuntimeException("the note you where looking for with the ID " + id + " is not found");
        }
        //now anbox the notOptional to give you teh object it is holding;

        Note note = noteOptional.get();
        // we return the DTO we needed.
        return dtoMapper.toNDto(note);
    }
// we are hoping the user send the jasson format
    public NoteDto updateNote(Long id, NoteDto noteDto){
        Optional<Note> optionalNote = noteRepository.findById(id);
        if(optionalNote.isEmpty()){
            throw  new RuntimeException("the data with that id coudln't be found");
        }
        Note not = optionalNote.get();
        if(!(noteDto.getContent()==null)){not.setContent(noteDto.getContent());

        }
        if(!(noteDto.getName()==(null))){
            not.setName(noteDto.getName());
        }
        noteRepository.save(not);
        return dtoMapper.toNDto(not);
    }

    public void deletNote(Long id) {
        if (noteRepository.findById(id).isEmpty()) {
            throw new RuntimeException("the note you were looking for with that id is not found");
        }
        noteRepository.deleteById(id);
    }


}
