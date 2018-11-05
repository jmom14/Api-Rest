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
import com.example.main.dto.PublicacionDTO;
import com.example.main.service.IPublicacionService;

@RestController
@RequestMapping("/v1")
public class PublicacionRest {
	
	@Autowired
	private IPublicacionService publicacionService;
	
	@PutMapping("/publicacion")
	public boolean addPublicacion(@RequestBody PublicacionDTO publicacion ) {
		
		return publicacionService.create(publicacion);
	}
	
	@DeleteMapping("/publicacion/{id}")
	public boolean deletePublicacion(@PathVariable(value = "id") Long id) {
		
		return publicacionService.delete(id);
	}
	
	@PutMapping("/publicacion/{id}")
	public boolean updatePublicacion(@PathVariable(value = "id") Long id,
             @RequestBody PublicacionDTO publicacion) {
		
		return publicacionService.update(id, publicacion);
	}
	
	@GetMapping("/publicacion/{id}")
	public PublicacionDTO getById(Long id) {
		
		return publicacionService.findById(id);
	}
	
	@GetMapping("/publicaciones")
	public List<PublicacionDTO> getAll(){
		
		return publicacionService.findAll();
	}

}
