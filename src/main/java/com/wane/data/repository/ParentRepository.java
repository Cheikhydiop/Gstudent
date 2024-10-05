package com.wane.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface ParentRepository<T, ID> extends JpaRepository<T, ID> {


}
