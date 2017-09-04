package com.main.controllers;

import com.main.models.ActivityArea;
import com.main.service.ActivityAreaService;
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
@RequestMapping(value = {"/activityarea"})
public class ActivityAreaControllers {

    @Autowired
    private ActivityAreaService activityareaService;

    @RequestMapping(value = {"", "/", "index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/activityarea/index");
        mv.addObject("activityareas", activityareaService.findAll());

        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create() {
        ActivityArea activityarea = new ActivityArea();
        ModelAndView mv = new ModelAndView("/activityarea/create");
        mv.addObject("activityarea", activityarea);

        return mv;
    }

    @PostMapping(value = "create")
    public ModelAndView create(@Valid ActivityArea activityarea, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/activityarea/create");
            mv.addObject("activityarea", activityarea);

            return mv;
        }

        activityareaService.save(activityarea);

        return new ModelAndView("redirect:/activityarea/index");
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("/activityarea/update");
        mv.addObject("activityarea", activityareaService.findOne(id));

        return mv;
    }

    @PostMapping("/update/{id}")
    public ModelAndView save(@PathVariable("id") Integer id, @Valid ActivityArea activityarea, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/activityarea/update");
            mv.addObject("activityarea", activityarea);

            return mv;
        }

        activityareaService.save(activityarea);
        return new ModelAndView("redirect:/activityarea/index");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        activityareaService.delete(id);
        return new ModelAndView("redirect:/activityarea/index");
    }
}
