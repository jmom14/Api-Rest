package com.example.main.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.dto.PublicationDTO;
import com.example.main.service.abstrct.IPublicationService;
import com.example.main.service.abstrct.IServices;

@RestController
@RequestMapping("/v1")
public class PublicationRest {
	
	@Autowired
	private IPublicationService publicationService;
	
	@PutMapping("/publications")
	public PublicationDTO addPublication(@RequestBody PublicationDTO publication) {
		return publicationService.create(publication);
	}
	
	@DeleteMapping("/publications/{id}")
	public boolean deletePublication(@PathVariable(value = "id") Long id) {
		return publicationService.delete(id);
	}
	
	@PutMapping("/publications/{id}")
	public boolean updatePublication(@PathVariable(value = "id") Long id,
             @RequestBody PublicationDTO publicacion) {
		return publicationService.update(publicacion, id);
	}
	
	@GetMapping("/publications/{id}")
	public PublicationDTO getById(Long id) {
		return publicationService.findById(id);
	}
	
	@GetMapping("/publications")
	public List<PublicationDTO> getAll(){
		return publicationService.findAll();
	}
	
	@GetMapping("/publicacions/paged")
	public List<PublicationDTO> getAllPaged(Pageable pageable){
		return publicationService.getPaged(pageable);
	}
}