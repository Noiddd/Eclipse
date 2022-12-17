package com.dion.hibernatejpa.hibernatejpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dion.hibernatejpa.hibernatejpa.entity.Course;
import com.dion.hibernatejpa.hibernatejpa.repository.CourseRepository;

@SpringBootApplication
public class HibernatejpaApplication implements CommandLineRunner {
	
	@Autowired
	private CourseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HibernatejpaApplication.class, args);
		System.out.println("test");
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = repository.findById(10001L);
		System.out.println("Course 10001 ---> " + course);
		
		repository.save(new Course("Javascript in 100 steps"));
		
	}
}
