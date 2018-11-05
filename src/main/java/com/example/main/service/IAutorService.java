package com.example.main.service;

import java.util.List;

import com.example.main.dto.AutorDTO;

public interface IAutorService {

	public boolean create(AutorDTO publicacion);
	
	public boolean delete(long id);
	
	public boolean update(long id);
	
	public List<AutorDTO> findAll();
	
	public AutorDTO findById(long id);
	
}
