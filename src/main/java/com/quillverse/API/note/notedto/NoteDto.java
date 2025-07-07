package com.quillverse.API.note.notedto;

public class NoteDto {
    private Long id;

    private String name;
    private String content;

    public NoteDto() {

    }

    public NoteDto(String name, String content) {
        this.name = name;
        this.content = content;

    }


    public NoteDto(Long Id, String name, String content) {
        this.id = Id;
        this.name = name;
        this.content = content;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setContent(String Contetent) {
        this.content = Contetent;
    }

    public String getContent() {
        return this.content;
    }
}
