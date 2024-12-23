package com.wane.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@NoRepositoryBean
public interface ParentRepository<T, ID> extends JpaRepository<T, ID> {


}
