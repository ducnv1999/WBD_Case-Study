package com.codegym.cms.model;

import javax.persistence.*;

@Entity
@Table(name = "Notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private NotesType notesType;

    public Notes() {
    }

    public Notes(String title, String content, NotesType notesType) {
        this.title = title;
        this.content = content;
        this.notesType = notesType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NotesType getNotesType() {
        return notesType;
    }

    public void setNotesType(NotesType notesType) {
        this.notesType = notesType;
    }
}
