package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.Project;
import com.codegym.portfolio.model.User;
import com.codegym.portfolio.service.ProjectService;
import com.codegym.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@ComponentScan("com.codegym.portfolio")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView listUser() {
        Iterable<User> user =userService.findAll();
        ModelAndView modelAndView = new ModelAndView("/User/listUser");
        modelAndView.addObject("users", user);
        return modelAndView;
    }

    @RequestMapping(value = "/createrUser", method = RequestMethod.GET)
    public ModelAndView showCreateUser() {
        ModelAndView modelAndView = new ModelAndView("/User/createUser");
        modelAndView.addObject("users", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("users") User user) {
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/User/createUser");
        modelAndView.addObject("users", new User());
        modelAndView.addObject("message", "New User created successfully");
        return modelAndView;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable Long id) {

        Optional<User> user = userService.findById(id);
        if (user != null) {
            ModelAndView modelAndView = new ModelAndView("/User/createUser");
            modelAndView.addObject("users", user);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView updateCustomer(@ModelAttribute("users") User user) {
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/User/editUser");
        modelAndView.addObject("user", user);
        modelAndView.addObject("message", "User updated successfully");
        return modelAndView;
    }
    @GetMapping("/deleteUser/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        User user = userService.findById(id).get();
        if(user != null) {
            ModelAndView modelAndView = new ModelAndView("/User/deleteUser");
            modelAndView.addObject("users", user);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-province")
    public String deleteProvince(@ModelAttribute("users") User user){
        userService.remove(user.getIdUser());
        return "redirect:/";
    }
}

