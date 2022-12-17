package com.dion.hibernatejpa.hibernatejpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dion.hibernatejpa.hibernatejpa.entity.Course;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	public Course save(Course course) {
		if(course.getId()==null) {
			// if there is not course, add it
			em.persist(course);
		} else {
			// if there is course, update it
			em.merge(course);
		}
		return course;
	}
}
