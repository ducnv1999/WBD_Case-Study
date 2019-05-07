package com.codegym.cms.service;

import com.codegym.cms.model.Notes;

public interface NotesService {
    Iterable<Notes> findAll();

    Notes findById(int id);

    void save(Notes notes);

    void remove(int id);
}
