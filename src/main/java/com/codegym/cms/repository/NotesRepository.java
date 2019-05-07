package com.codegym.cms.repository;

import com.codegym.cms.model.Notes;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotesRepository extends PagingAndSortingRepository<Notes,Integer> {
}
