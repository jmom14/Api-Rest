package com.example.main.service;

import java.util.List;

import com.example.main.dto.PublicacionDTO;
import com.example.main.entities.Publicacion;


public interface IPublicacionService {
	
	public boolean create(PublicacionDTO publicacion);
	
	public boolean delete(long id);
	
	public boolean update(long id, PublicacionDTO publicacion);
	
	public List<PublicacionDTO> findAll();
	
	public PublicacionDTO findById(long id);
	
	

}
