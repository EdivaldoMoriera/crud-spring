package com.valdosm.crudspring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valdosm.crudspring.controller.Courses;
import com.valdosm.crudspring.repository.CoursesRepository;

@SpringBootApplication
public class CrudSpringApplication implements CommandLineRunner{
	@Autowired
	private CoursesRepository coursesRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
	  Courses courses1 = new Courses(null, "Java", "backend");
	  Courses courses2 = new Courses(null, "Spring", "backend");
	  Courses courses3 = new Courses(null, "Angular", "frontend");

	  coursesRepository.saveAll(Arrays.asList(courses1, courses2, courses3));
		
	}

}
