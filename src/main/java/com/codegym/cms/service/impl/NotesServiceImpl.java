package com.codegym.cms.service.impl;

import com.codegym.cms.model.Notes;
import com.codegym.cms.repository.NotesRepository;
import com.codegym.cms.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;

public class NotesServiceImpl implements NotesService {
    @Autowired
    NotesRepository notesRepository;
    @Override
    public Iterable<Notes> findAll() {
        return notesRepository.findAll();
    }

    @Override
    public Notes findById(int id) {
        return notesRepository.findOne(id);
    }

    @Override
    public void save(Notes notes) {
        notesRepository.save(notes);
    }

    @Override
    public void remove(int id) {
        notesRepository.delete(id);
    }
}
