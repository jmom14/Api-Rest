package com.example.main.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.dto.AutorDTO;
import com.example.main.service.AutorService;

@RestController
@RequestMapping("/v1")
public class AutorRest {
	
	@Autowired
	private AutorService autorService;
	
	@PutMapping("/autores")
	public AutorDTO addAutor(@RequestBody AutorDTO autor) {
		
		return autorService.create(autor);
	}
	
	@DeleteMapping("/autores/{id}")
	public boolean deleteAutor(@PathVariable(value ="id") long id) {
		
		return autorService.delete(id);
	}
	
	@PutMapping("/autores/{id}")
	public boolean updateAutor(@PathVariable(value ="id") long id, 
											    @RequestBody AutorDTO autor) {
		
		return autorService.update(id, autor);
	}
	
	@GetMapping("/autores")
	public List<AutorDTO> getAll(){
		
		return autorService.findAll(); 
	}
	
	@GetMapping("/autores/{id}")
	public AutorDTO getById(@PathVariable(value = "id") long id) {
		
		return autorService.findById(id);
	}
	

}
