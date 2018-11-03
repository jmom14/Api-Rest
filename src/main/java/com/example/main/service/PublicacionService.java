package com.example.main.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.converter.Converter;
import com.example.main.dto.PublicacionDTO;
import com.example.main.entities.Publicacion;
import com.example.main.repository.PublicacionRepository;

@Service
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
