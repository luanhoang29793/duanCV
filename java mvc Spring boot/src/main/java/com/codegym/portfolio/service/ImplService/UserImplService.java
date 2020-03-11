package com.codegym.portfolio.service.ImplService;

import com.codegym.portfolio.model.Project;
import com.codegym.portfolio.model.User;
import com.codegym.portfolio.repository.UserRepository;
import com.codegym.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class UserImplService implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
    userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
userRepository.deleteById(id);
    }


}
