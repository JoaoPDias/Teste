package com.main.controllers;

import com.main.models.Person;
import com.main.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/", "/person"})
public class PersonControllers {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = {"", "/", "index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/person/index");
        mv.addObject("persons", personService.findAll());

        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create() {
        Person person = new Person();
        ModelAndView mv = new ModelAndView("/person/create");
        mv.addObject("person", person);

        return mv;
    }

    @PostMapping(value = "create")
    public ModelAndView create(@Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/person/create");
            mv.addObject("person", person);

            return mv;
        }

        personService.save(person);

        return new ModelAndView("redirect:/person/");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        personService.delete(id);
        return new ModelAndView("redirect:/person/");
    }
}
