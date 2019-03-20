package com.example.main.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.main.dto.PublicacionDTO;

@Service
public interface IPublicacionService {
	
	public PublicacionDTO create(PublicacionDTO publicacion);
	
	public boolean delete(long id);
	
	public boolean update(long id, PublicacionDTO publicacion);
	
	public List<PublicacionDTO> findAll();
	
	public PublicacionDTO findById(long id);
	
	public List<PublicacionDTO> getPaged(Pageable pageable);
	
	

}
