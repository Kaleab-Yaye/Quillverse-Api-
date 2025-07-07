package com.quillverse.API.note;

import jakarta.persistence.*;
// the entiity tells the hibrane to crate a table
@Entity
public class Note {
    // Id tell hibrnatee to treat the followign instance as a private key
    @Id
    // this tells hibrante to not care abotu assining values to the private keys insteas let postgrsql to hadle it with out incrimanatation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    // all the following are elmens of the sema they are attribuits
    @Column(nullable = false)

    private String name;
    private String content ;
    public Note(){

    }

    public Note(String name , String Content){
        this.name = name;
        this.content  = Content;

    }

    public void setId(Long Id){
        this.Id = Id;
    }
    public Long getId() {
        return Id;
    }

    public void setName(String name){
        this.name = name ;
    }
    public String getName() {
        return name;
    }
    public void setContent(String Contetent){
        this.content = Contetent;
    }
    public String getContent() {
        return content;
    }

    }
