package com.example.service;

import java.util.List;

import com.example.dto.PublicacionDTO;
import com.example.entities.Publicacion;


public interface IPublicacionService {
	
	public boolean create(Publicacion publicacion);
	
	public boolean delete(long id);
	
	public boolean update(long id);
	
	public List<PublicacionDTO> findAll();
	
	public PublicacionDTO findById(long id);
	
	

}
