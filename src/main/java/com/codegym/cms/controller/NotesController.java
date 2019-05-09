package com.codegym.cms.controller;

import com.codegym.cms.model.Notes;
import com.codegym.cms.model.NotesType;
import com.codegym.cms.service.NotesService;
import com.codegym.cms.service.NotesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class NotesController {
    @Autowired
    NotesService notesService;
    @Autowired
    NotesTypeService notesTypeService;


    @ModelAttribute("types")
    public Iterable<NotesType> notesType() {
        return notesTypeService.findAll();
    }


    @GetMapping("/notes")
    public ModelAndView listNotes(@PageableDefault(value = 6) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("notes/list");
        modelAndView.addObject("notes", notesService.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/create-notes")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("notes/create");
        modelAndView.addObject("notes",new  Notes());
        return modelAndView;
    }

    @PostMapping("/create-notes")
    public ModelAndView saveNotes(@ModelAttribute Notes notes){
        notesService.save(notes);
        ModelAndView modelAndView = new ModelAndView("notes/create");
        modelAndView.addObject("notes", new Notes());
        modelAndView.addObject("message", " New jobs created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-notes/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Notes notes = notesService.findById(id);
        ModelAndView modelAndView = new ModelAndView("notes/edit");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }
    @PostMapping("/edit-notes")
    public ModelAndView updateNotes(@ModelAttribute("notes")Notes notes){
        notesService.save(notes);
        ModelAndView modelAndView = new ModelAndView("notes/edit");
        modelAndView.addObject("notes", notes);
        modelAndView.addObject("message", "The job has been changed");
        return modelAndView;
    }
    @GetMapping("/delete-notes/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        notesService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/notes");
        redirectAttributes.addFlashAttribute("message", "notes was deleted");
        return modelAndView;
    }
    @GetMapping("/view-notes/{id}")
    public ModelAndView showViewForm(@PathVariable Integer id){
        Notes notes = notesService.findById(id);
        ModelAndView modelAndView = new ModelAndView("notes/view");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }
}

