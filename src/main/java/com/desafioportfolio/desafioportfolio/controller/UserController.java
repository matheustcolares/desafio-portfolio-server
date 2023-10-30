package com.desafioportfolio.desafioportfolio.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioportfolio.desafioportfolio.model.User;
import com.desafioportfolio.desafioportfolio.repository.UserRepository;
import com.desafioportfolio.desafioportfolio.security.JwtTokenProvider;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	
	@GetMapping(value ="/all",produces = "application/json")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
	}
	@GetMapping(value ="/find/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") long id) {
		return new ResponseEntity<>(repository.findById(id).get(),HttpStatus.OK);
	}
	@Transactional
	@PostMapping(value ="/save",consumes = "application/json",produces = "application/json")
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
	
	@GetMapping(value="/getByUsername/{username}",produces = "application/json")
	public ResponseEntity<User> getByUsername(@PathVariable("username") String username){
		return new ResponseEntity<>(repository.findByUsername(username),HttpStatus.OK);
	}
}
