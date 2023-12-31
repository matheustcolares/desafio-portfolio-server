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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioportfolio.desafioportfolio.model.Discipline;
import com.desafioportfolio.desafioportfolio.repository.DisciplineRepository;

@RestController
@RequestMapping(value ="/discipline" )
@CrossOrigin(origins = "*")
public class DiscilpineController {
	
	@Autowired
	private DisciplineRepository repository;
	
	@GetMapping(value ="/all")
	public ResponseEntity<List<Discipline>> getAll() {
		return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
	}
	@GetMapping(value ="/find/{id}")
	public ResponseEntity<Discipline> findById(@PathVariable("id") long id) {
		return new ResponseEntity<>(repository.findById(id).get(),HttpStatus.OK);
	}
	@Transactional
	@PostMapping(value ="/save",consumes = "*/*",produces = "*/*")
	public ResponseEntity<Discipline> save(@RequestBody Discipline discipline) {
		return new ResponseEntity<>(repository.save(discipline),HttpStatus.OK);
	}
	@DeleteMapping(value ="/delete/{id}")
	public ResponseEntity<Discipline> delete(@PathVariable("id") long id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
