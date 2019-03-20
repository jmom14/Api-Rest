package com.example.main.service;

import java.util.List;

import com.example.main.dto.AutorDTO;

public interface IAutorService {

	public AutorDTO create(AutorDTO autor);
	
	public boolean delete(long id);
	
	public boolean update(long id, AutorDTO autor);
	
	public List<AutorDTO> findAll();
	
	public AutorDTO findById(long id);
	
}
