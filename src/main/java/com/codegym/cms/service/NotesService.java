package com.codegym.cms.service;

import com.codegym.cms.model.Notes;
import com.codegym.cms.model.NotesType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotesService {
    Page<Notes> findAll(Pageable pageable);

    Notes findById(int id);

    void save(Notes notes);

    void remove(int id);

    Page<Notes> findAllByTitleContaining(String title, Pageable pageable);

    Page<Notes> findAllByType(NotesType notesType, Pageable pageable);
}
