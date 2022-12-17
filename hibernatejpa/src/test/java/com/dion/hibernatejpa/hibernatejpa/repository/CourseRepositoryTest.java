package com.dion.hibernatejpa.hibernatejpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.dion.hibernatejpa.hibernatejpa.entity.Course;

@SpringBootTest
class CourseRepositoryTest {
	@Autowired
	CourseRepository repository;
	
	@Test
	public void findById_basic() {		
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {		
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {		
		// get a course
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());

		// update details of course
		course.setName("JPA in 50 steps, updated");
		repository.save(course);
		
		//check the value
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 steps, updated", course1.getName());
	}
	
}
