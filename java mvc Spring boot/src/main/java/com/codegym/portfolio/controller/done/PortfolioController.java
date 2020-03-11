package com.codegym.portfolio.controller.done;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan("com.codegym.portfolio")
@RestController
public class PortfolioController {
    @RequestMapping(value= "/done", method= RequestMethod.GET)
    public ModelAndView layout() {

        ModelAndView modelAndView = new ModelAndView("/done/index");

        return modelAndView;
    }
}
