package com.codegym.cms.controller;

import com.codegym.cms.model.NotesType;
import com.codegym.cms.service.NotesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotesTypeController {

    @Autowired
    private NotesTypeService notesTypeService;


    @GetMapping("/types")
    public ModelAndView listNotesType() {
        ModelAndView modelAndView = new ModelAndView("NoteType/list");
        modelAndView.addObject("notesTypes", notesTypeService.findAll());
        return modelAndView;
    }
    @GetMapping("/types-create")
    public ModelAndView createNotesType(){
        ModelAndView modelAndView = new ModelAndView("NoteType/create");
        modelAndView.addObject("notesType", new NotesType());
        return modelAndView;
    }
    @PostMapping("/types-create")
    public ModelAndView saveCreate(@ModelAttribute("notesType") NotesType notesType){
    notesTypeService.save(notesType);
    ModelAndView modelAndView = new ModelAndView("NoteType/create");
    modelAndView.addObject("notesType", new NotesType());
    modelAndView.addObject("message", "New notes type was added");
    return modelAndView;
    }

    @GetMapping("/types-edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        NotesType notesType = notesTypeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("NoteType/edit");
        modelAndView.addObject("notesType", notesType);
        return modelAndView;
    }
    @PostMapping("/types-edit")
    public ModelAndView saveEdit(@ModelAttribute("notesType") NotesType notesType){
        notesTypeService.save(notesType);

        ModelAndView modelAndView = new ModelAndView("NoteType/edit");
        modelAndView.addObject("notesType", notesType);
        modelAndView.addObject("message", "Successful category updates ");
        return modelAndView;
    }



}