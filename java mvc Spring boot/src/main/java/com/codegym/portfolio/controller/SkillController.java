package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.Skill;
import com.codegym.portfolio.repository.SkillRepository;
import com.codegym.portfolio.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan("com.codegym.portfolio")
@RestController
public class SkillController {
    @Autowired
    private SkillService skillService;
    @RequestMapping(value = "/skill", method = RequestMethod.GET)
    public ModelAndView listSkill(){
        Iterable<Skill> skills =skillService.findAll();
        ModelAndView modelAndView = new ModelAndView("/Skill/list");
        modelAndView.addObject("listSkill", skills);
        return modelAndView;
    }

}
