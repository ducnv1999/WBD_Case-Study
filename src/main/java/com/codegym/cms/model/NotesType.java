package com.codegym.cms.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "notesType")
public class NotesType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(targetEntity = Notes.class)
    private List<Notes> notes;

    public NotesType(){
    }

    public NotesType(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }
}
