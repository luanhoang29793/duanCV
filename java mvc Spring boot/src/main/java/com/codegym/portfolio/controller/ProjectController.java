package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.Project;
import com.codegym.portfolio.model.ProjectUpload;
import com.codegym.portfolio.model.User;
import com.codegym.portfolio.service.ProjectService;
import com.codegym.portfolio.service.SkillService;
import com.codegym.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@ComponentScan("com.codegym.portfolio")
@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @ModelAttribute("users")
    public Iterable<User> users(){
        return userService.findAll();
    }

    @RequestMapping(value= "/", method= RequestMethod.GET)
    public ModelAndView listProject() {
    List<Project> projects =(List<Project>) projectService.findAll();
    ModelAndView modelAndView = new ModelAndView("/Project/list");
   modelAndView.addObject("projectList", projects);
    return modelAndView;
    }
    // View User
    @GetMapping("/view-User/{id}")
    public ModelAndView viewUser(@PathVariable("id") Long id){
        User user = userService.findById(id).get();
        if(user == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Project> projects = projectService.findAllByUser(user);

        ModelAndView modelAndView = new ModelAndView("/Project/view");
        modelAndView.addObject("users", user);
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }
    // create Project
    @RequestMapping(value= "/create-project", method = RequestMethod.GET)
    public ModelAndView showCreateProject(@ModelAttribute("projectUpload") ProjectUpload projectUpload){
        ModelAndView modelAndView = new ModelAndView("/Project/create");
        modelAndView.addObject("project", new Project());
        modelAndView.addObject("projectUpload", new ProjectUpload());
        return modelAndView;
    }
    @RequestMapping(value= "/create-project", method = RequestMethod.POST)
    public ModelAndView createProject(@ModelAttribute("projectUpload") ProjectUpload projectUpload) throws IOException {

        ModelAndView modelAndView = new ModelAndView("/Project/create");
        MultipartFile file = projectUpload.getFile();
        projectService.uploadFile(file);

        String imageName = file.getOriginalFilename();
        Project project = new Project();
        project.setNameProject(projectUpload.getNameProject());
        project.setDescriptionProject(projectUpload.getDescriptionProject());
        project.setSummaryProject(projectUpload.getSummaryProject());
        project.setImagesProject(imageName);
        projectService.save(project);
        modelAndView.addObject("projectUpload",new ProjectUpload());
        modelAndView.addObject("message", "Tao thanh cong");
    return modelAndView;
    }
    @RequestMapping(value = "/edit-project/{id}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable Long id){
        Project project = projectService.findById(id);
        if(project != null) {
            ModelAndView modelAndView = new ModelAndView("Project/edit");
            modelAndView.addObject("project", project);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @RequestMapping( value="/edit-project", method = RequestMethod.POST)
    public ModelAndView updateProvince(@ModelAttribute("project") Project project){
        projectService.save(project);
        ModelAndView modelAndView = new ModelAndView("Project/edit");
        modelAndView.addObject("project", project);
        modelAndView.addObject("message", "sua thanh cong");
        return modelAndView;
    }
    @RequestMapping(value ="/delete-project/{id}", method = RequestMethod.GET)
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Project project = projectService.findById(id);
        if(project != null) {
            ModelAndView modelAndView = new ModelAndView("Project/delete");
            modelAndView.addObject("project", project);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-user")
    public String deleteProvince(@ModelAttribute("project") Project project){
        projectService.remove(project.getIdProject());
        return "redirect:/";
    }
    @RequestMapping(value= "/top3", method= RequestMethod.GET)
    public ModelAndView listtop3() {
        Iterable<Project> projects =projectService.top3();
        ModelAndView modelAndView = new ModelAndView("/Project/top3");
        modelAndView.addObject("projectList", projects);
        return modelAndView;
    }
}
