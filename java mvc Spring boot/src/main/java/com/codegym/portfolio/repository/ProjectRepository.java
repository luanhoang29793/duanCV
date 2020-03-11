package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.Project;
import com.codegym.portfolio.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    @Query(value= "SELECT  * FROM project ORDER BY id_project DESC LIMIT 3", nativeQuery = true)
    Iterable<Project> top3();
    Iterable<Project> findAllByUser(User user);
}
