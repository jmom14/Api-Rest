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
public class PublicacionRest {
	
	@Autowired
	private IPublicationService publicacionService;
	
	@PutMapping("/publicaciones")
	public PublicationDTO addPublicacion(@RequestBody PublicationDTO publicacion ) {
		
		return publicacionService.create(publicacion);
	}
	
	@DeleteMapping("/publicaciones/{id}")
	public boolean deletePublicacion(@PathVariable(value = "id") Long id) {
		
		return publicacionService.delete(id);
	}
	
	@PutMapping("/publicaciones/{id}")
	public boolean updatePublicacion(@PathVariable(value = "id") Long id,
             @RequestBody PublicationDTO publicacion) {
		
		return publicacionService.update(publicacion, id);
	}
	
	@GetMapping("/publicaciones/{id}")
	public PublicationDTO getById(Long id) {
		
		return publicacionService.findById(id);
	}
	
	@GetMapping("/publicaciones")
	public List<PublicationDTO> getAll(){
		
		return publicacionService.findAll();
	}
	
	@GetMapping("/publicaciones/paged")
	public List<PublicationDTO> getAllPaged(Pageable pageable){
		
		return publicacionService.getPaged(pageable);
	}
	
	

}
