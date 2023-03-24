package com.valdosm.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valdosm.crudspring.controller.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {
    
}
