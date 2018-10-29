package com.example.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.Publicacion;
import com.example.service.IPublicacionService;

@RestController
@RequestMapping("/v1")
public class PublicacionRest {
	
	@Autowired
	private IPublicacionService publicacionService;
	
	@PutMapping("/publicacion")
	public boolean agregarPublicacion(@RequestBody Publicacion publicacion ) {
		return publicacionService.create(publicacion);
	}

}
