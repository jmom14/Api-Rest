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
public class AuthorRest {
	
	@Autowired
	private IAuthorService authorService;
	
	@PutMapping("/authores")
	public AuthorDTO addAuthor(@RequestBody AuthorDTO author) {		
		return authorService.create(author);
	}
	
	@DeleteMapping("/authores/{id}")
	public boolean deleteAuthor(@PathVariable(value ="id") long id) {
		return authorService.delete(id);
	}
	
	@PutMapping("/authores/{id}")
	public boolean updateAuthor(@PathVariable(value ="id") long id, 
											    @RequestBody AuthorDTO author) {
		return authorService.update(author, id);
	}
	
	@GetMapping("/authores")
	public List<AuthorDTO> getAll(){
		return authorService.findAll(); 
	}
	
	@GetMapping("/authores/{id}")
	public AuthorDTO getById(@PathVariable(value = "id") long id) {		
		return authorService.findById(id);
	}
}