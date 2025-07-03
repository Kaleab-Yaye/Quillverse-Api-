package com.quillverse.API.Note;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository <Note, Long> {

}
