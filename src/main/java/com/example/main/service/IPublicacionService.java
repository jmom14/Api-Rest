package com.example.main.service;

import java.util.List;

import com.example.main.dto.PublicacionDTO;
import com.example.main.entities.Publicacion;


public interface IPublicacionService {
	
	public boolean create(Publicacion publicacion);
	
	public boolean delete(long id);
	
	public boolean update(long id);
	
	public List<PublicacionDTO> findAll();
	
	public PublicacionDTO findById(long id);
	
	

}
