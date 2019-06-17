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

import com.example.main.dto.AuthorDTO;
import com.example.main.service.abstrct.IAuthorService;

@RestController
@RequestMapping("/v1")
public class AutorRest {
	
	@Autowired
	private IAuthorService authorService;
	
	@PutMapping("/autores")
	public AuthorDTO addAutor(@RequestBody AuthorDTO autor) {
		
		return authorService.create(autor);
	}
	
	@DeleteMapping("/autores/{id}")
	public boolean deleteAutor(@PathVariable(value ="id") long id) {
		
		return authorService.delete(id);
	}
	
	@PutMapping("/autores/{id}")
	public boolean updateAutor(@PathVariable(value ="id") long id, 
											    @RequestBody AuthorDTO autor) {
		
		return authorService.update(autor, id);
	}
	
	@GetMapping("/autores")
	public List<AuthorDTO> getAll(){
		
		return authorService.findAll(); 
	}
	
	@GetMapping("/autores/{id}")
	public AuthorDTO getById(@PathVariable(value = "id") long id) {
		
		return authorService.findById(id);
	}
	

}
