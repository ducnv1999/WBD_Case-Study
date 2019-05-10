package com.codegym.cms.repository;

import com.codegym.cms.model.Notes;
import com.codegym.cms.model.NotesType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotesRepository extends PagingAndSortingRepository<Notes,Integer> {
    Page<Notes> findAllByTitleContaining(Pageable pageable,String title);

    Page<Notes> findAllByNotesType(NotesType notesType, Pageable pageable);
}
