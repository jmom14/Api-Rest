package com.example.main.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.converter.Converter;
import com.example.main.dto.NacionalidadDTO;
import com.example.main.service.NacionalidadService;

@RestController
@RequestMapping("/v1")
public class NacionalidadRest {
	
	@Autowired
	private NacionalidadService nacionalidadService;

	@PutMapping("/nacionalidades")
	public NacionalidadDTO addNacionalidad(@RequestBody NacionalidadDTO nacionalidad) {
		
		return nacionalidadService.create(nacionalidad);
	}
	
	@DeleteMapping("/nacionalidades/{id}")
	public boolean deleteNacionalidad(@PathVariable(value ="id") long id) {
		
		return nacionalidadService.delete(id);
	}
	
	@PutMapping("/nacionalidades/{id}")
	public boolean updateNacionalidad(@PathVariable(value="id") long id,
														  @RequestBody NacionalidadDTO nacionalidad) {
		return nacionalidadService.update(id, nacionalidad);
		
	}
	
	@GetMapping("/nacionalidades")
	public List<NacionalidadDTO> getAll(){
		
		return nacionalidadService.findAll();
	}

	@GetMapping("/nacionalidades/{id}")
	public NacionalidadDTO getById(@PathVariable(value = "id") long id) {
		
		return nacionalidadService.findById(id);
	}

}
