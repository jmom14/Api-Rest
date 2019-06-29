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
public class NacionalityRest {
	
	@Autowired
	private INacionalityService nacionalityService;

	@PutMapping("/nacionalities")
	public NacionalityDTO addNacionality(@RequestBody NacionalityDTO nacionality) {
		return nacionalityService.create(nacionality);
	}
	
	@DeleteMapping("/nacionalities/{id}")
	public boolean deleteNacionality(@PathVariable(value ="id") long id) {
		return nacionalityService.delete(id);
	}
	
	@PutMapping("/nacionalities/{id}")
	public boolean updateNacionality(@PathVariable(value = "id") long id,
														  @RequestBody NacionalityDTO nacionality) {
		return nacionalityService.update(nacionality, id);
	}
	
	@GetMapping("/nacionalities")
	public List<NacionalityDTO> getAll(){
		return nacionalityService.findAll();
	}

	@GetMapping("/nacionalities/{id}")
	public NacionalityDTO getById(@PathVariable(value = "id") long id) {
		return nacionalityService.findById(id);
	}
}