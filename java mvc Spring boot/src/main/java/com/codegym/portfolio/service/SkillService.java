package com.codegym.portfolio.service;

import com.codegym.portfolio.model.Skill;
import org.springframework.stereotype.Service;

@Service
public interface SkillService {
    Iterable<Skill> findAll();
    Skill findById(Long id);
    void save(Skill skill);
    void remove( Long id);
}
