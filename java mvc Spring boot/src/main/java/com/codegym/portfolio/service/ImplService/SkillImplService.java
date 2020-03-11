package com.codegym.portfolio.service.ImplService;

import com.codegym.portfolio.model.Skill;
import com.codegym.portfolio.repository.SkillRepository;
import com.codegym.portfolio.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SkillImplService implements SkillService {
    @Autowired
    SkillRepository skillRepository;


    @Override
    public Iterable<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill findById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Skill skill) {
    skillRepository.save(skill);
    }

    @Override
    public void remove(Long id) {
        skillRepository.deleteById(id);

    }
}
