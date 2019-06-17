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

import com.example.main.dto.NacionalityDTO;
import com.example.main.service.NacionalityService;
import com.example.main.service.abstrct.INacionalityService;

@RestController
@RequestMapping("/v1")
public class NacionalidadRest {
	
	@Autowired
	private INacionalityService nacionalidadService;

	@PutMapping("/nacionalidades")
	public NacionalityDTO addNacionalidad(@RequestBody NacionalityDTO nacionalidad) {
		
		return nacionalidadService.create(nacionalidad);
	}
	
	@DeleteMapping("/nacionalidades/{id}")
	public boolean deleteNacionalidad(@PathVariable(value ="id") long id) {
		
		return nacionalidadService.delete(id);
	}
	
	@PutMapping("/nacionalidades/{id}")
	public boolean updateNacionalidad(@PathVariable(value = "id") long id,
														  @RequestBody NacionalityDTO nacionalidad) {
		return nacionalidadService.update(nacionalidad, id);
		
	}
	
	@GetMapping("/nacionalidades")
	public List<NacionalityDTO> getAll(){
		
		return nacionalidadService.findAll();
	}

	@GetMapping("/nacionalidades/{id}")
	public NacionalityDTO getById(@PathVariable(value = "id") long id) {
		
		return nacionalidadService.findById(id);
	}

}
