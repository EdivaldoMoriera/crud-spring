package com.valdosm.crudspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdosm.crudspring.controller.Courses;
import com.valdosm.crudspring.repository.CoursesRepository;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;
    public List<Courses> findAll(){
        return coursesRepository.findAll();
    }
    //por id
    public Courses findById(Integer id){
        Optional<Courses> obj = coursesRepository.findById(id);
        return obj.get();
    }
    //post
    public Courses insert( Courses courses){
        return coursesRepository.save(courses);

    }
}
