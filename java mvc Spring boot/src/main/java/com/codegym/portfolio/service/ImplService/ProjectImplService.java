package com.codegym.portfolio.service.ImplService;

import com.codegym.portfolio.model.Project;
import com.codegym.portfolio.model.User;
import com.codegym.portfolio.repository.ProjectRepository;
import com.codegym.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Repository
public class ProjectImplService implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Iterable<Project> findAll() {
        return  projectRepository.findAll();
    }
    @Override
    public Iterable<Project> top3(){
        return projectRepository.top3();
    }

    @Override
    public Project findById(Long Id) {
        return projectRepository.findById(Id).orElse(null);
    }

    @Override
    public void save(Project project) {
    projectRepository.save(project);
    }

    @Override
    public void remove(Long id) {
    projectRepository.deleteById(id);
    }
    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("D:\\du an cv\\java mvc Spring boot\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename()));
    }

    @Override
    public Iterable<Project> findAllByUser(User user) {
        return projectRepository.findAllByUser(user);
    }


}
