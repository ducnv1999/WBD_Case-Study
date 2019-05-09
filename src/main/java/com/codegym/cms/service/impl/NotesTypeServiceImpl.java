package com.codegym.cms.service.impl;

import com.codegym.cms.model.NotesType;
import com.codegym.cms.repository.NotesTypeRepository;
import com.codegym.cms.service.NotesTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class NotesTypeServiceImpl implements NotesTypeService {

    @Autowired
    private NotesTypeRepository notesTypeRepository;

    @Override
    public Iterable<NotesType> findAll() {
        return notesTypeRepository.findAll();
    }

    @Override
    public NotesType findById(int id) {
        return notesTypeRepository.findOne(id);
    }

    @Override
    public void save(NotesType notesType) {
        notesTypeRepository.save(notesType);

    }

    @Override
    public void remove(int id) {
        notesTypeRepository.delete(id);

    }
}
