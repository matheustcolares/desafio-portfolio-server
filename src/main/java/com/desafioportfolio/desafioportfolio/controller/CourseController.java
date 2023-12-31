package com.desafioportfolio.desafioportfolio.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioportfolio.desafioportfolio.model.Course;
import com.desafioportfolio.desafioportfolio.model.User;
import com.desafioportfolio.desafioportfolio.repository.CourseRepository;

@RestController
@RequestMapping(value="/course")
@CrossOrigin(origins = "*")
public class CourseController {

	@Autowired
	private CourseRepository repository;
	
	@GetMapping(value ="/all")
	public ResponseEntity<List<Course>> getAll() {
		return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
	}
	@GetMapping(value ="/find/{id}")
	public ResponseEntity<Course> findById(@PathVariable("id") long id) {
		return new ResponseEntity<>(repository.findById(id).get(),HttpStatus.OK);
	}
	@Transactional
	@PostMapping(value ="/save",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Course> save(@RequestBody Course course) {
		return new ResponseEntity<>(repository.save(course),HttpStatus.OK);
	}
	@Transactional
	@PutMapping(value ="/update",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Course> update(@RequestBody Course course) {
		return new ResponseEntity<>(repository.save(course),HttpStatus.OK);
	}
	@DeleteMapping(value ="/delete/{id}")
	public ResponseEntity<Course> delete(@PathVariable("id") long id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
