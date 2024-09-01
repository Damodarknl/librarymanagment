package com.library.management.repository;

import com.library.management.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {}