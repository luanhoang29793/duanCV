package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.Skill;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SkillRepository extends PagingAndSortingRepository<Skill, Long> {
}
