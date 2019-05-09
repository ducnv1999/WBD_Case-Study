package com.codegym.cms.service;

import com.codegym.cms.model.NotesType;

public interface NotesTypeService {
    Iterable<NotesType> findAll();

    NotesType findById(int id);

    void save (NotesType notesType);
    void remove (int id);


}
