package com.codegym.portfolio.service;

import com.codegym.portfolio.model.Project;
import com.codegym.portfolio.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UserService {
    Iterable<User> findAll();
    Optional<User> findById( Long id);
    void save(User user);
    void remove(Long id);
}
