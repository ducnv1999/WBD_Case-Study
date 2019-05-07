package com.codegym.cms.controller;

import com.codegym.cms.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotesController {
    @Autowired
    NotesService notesService;
    @GetMapping("/notes")
    public ModelAndView showListNote(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("notes",notesService.findAll());
        return modelAndView;
    }
}
