package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.Project;
import com.codegym.portfolio.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
