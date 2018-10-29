package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.converter.Converter;
import com.example.dto.PublicacionDTO;
import com.example.entities.Publicacion;
import com.example.repository.PublicacionRepository;

public class PublicacionService implements IPublicacionService {

	@Autowired
	private PublicacionRepository publicacionRepository;
	
	@Autowired 
	private Converter converter;

	@Override
	public boolean create(Publicacion publicacion) {
		try {
			publicacionRepository.save(publicacion);
		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public boolean delete(long id) {

		try {

			Publicacion entity = publicacionRepository.findByIdPublicacion(id);
			publicacionRepository.delete(entity);

		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public boolean update(long id) {
		try {

		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public List<PublicacionDTO> findAll() {
		List<PublicacionDTO> out = null;

		try {		
			out = converter.convertirPublicaciones(publicacionRepository.findAll());
		} catch (Exception e) {
			
		}
		
		return out;
	}

	@Override
	public PublicacionDTO findById(long id) {
		PublicacionDTO out = null;
		try {
			
			out = converter.convertirPublicacion(publicacionRepository.findByIdPublicacion(id));
		} catch (Exception e) {

		}
		return out;
	}

}
