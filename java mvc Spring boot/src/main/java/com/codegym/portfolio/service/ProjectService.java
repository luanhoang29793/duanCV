package com.codegym.portfolio.service;

import com.codegym.portfolio.model.Project;
import com.codegym.portfolio.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public interface ProjectService {
    Iterable<Project> findAll();
    Iterable<Project> top3();
    Project findById(Long Id);
    void save (Project project);
    void remove(Long id);
    void uploadFile(MultipartFile file) throws IOException;
    Iterable<Project> findAllByUser(User user);
}
