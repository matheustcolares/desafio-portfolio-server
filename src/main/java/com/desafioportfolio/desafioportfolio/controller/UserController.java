package com.desafioportfolio.desafioportfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioportfolio.desafioportfolio.model.User;
import com.desafioportfolio.desafioportfolio.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping(value ="/all")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
	}
	@GetMapping(value ="/update/{id}")
	public ResponseEntity<User> update(@PathVariable("id") long id) {
		return new ResponseEntity<>(repository.findById(id).get(),HttpStatus.OK);
	}
	@PostMapping(value ="/save")
	public ResponseEntity<User> save(@RequestBody User user) {
		return new ResponseEntity<>(repository.save(user),HttpStatus.OK);
	}
	@DeleteMapping(value ="/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable("id") long id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
