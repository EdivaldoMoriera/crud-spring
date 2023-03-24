package com.valdosm.crudspring.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.valdosm.crudspring.controller.Courses;
import com.valdosm.crudspring.service.CoursesService;

@RestController
@RequestMapping(value = "api/courses")
public class CoursesRest {
    @Autowired
    private CoursesService coursesService;
    @GetMapping
    public ResponseEntity<List<Courses>> findAll(){
        List<Courses> list = coursesService.findAll();
        return ResponseEntity.ok().body(list);

    }
    //por id
    @RequestMapping(value ="/{id}")
    @GetMapping
    public ResponseEntity<Courses>findById(@PathVariable Integer id){
        Courses courses = coursesService.findById(id);
            return ResponseEntity.ok().body(courses);
        }
        @PostMapping
        public ResponseEntity<Courses> insert(@RequestBody Courses courses){
            courses = coursesService.insert(courses);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(courses.getId()).toUri();
            return ResponseEntity.created(uri).body(courses);

        }

}
