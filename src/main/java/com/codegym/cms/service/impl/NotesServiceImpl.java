package com.codegym.cms.service.impl;

import com.codegym.cms.model.Notes;
import com.codegym.cms.model.NotesType;
import com.codegym.cms.repository.NotesRepository;
import com.codegym.cms.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NotesServiceImpl implements NotesService {
    @Autowired
    NotesRepository notesRepository;
    @Override
    public Page<Notes> findAll(Pageable pageable) {
        return notesRepository.findAll(pageable);
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

    @Override
    public Page<Notes> findAllByTitleContaining(String title, Pageable pageable) {
        return notesRepository.findAllByTitleContaining(pageable,title);
    }

    @Override
    public Page<Notes> findAllByType(NotesType notesType, Pageable pageable) {
        return notesRepository.findAllByNotesType(notesType,pageable);
    }



}
