package com.example.main.service;


import java.util.List;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.converter.Converter;
import com.example.main.dto.PublicacionDTO;
import com.example.main.entities.Autor;
import com.example.main.entities.Publicacion;
import com.example.main.repository.AutorRepository;
import com.example.main.repository.PublicacionRepository;

@Service
public class PublicacionService implements IPublicacionService {

	@Autowired private PublicacionRepository publicacionRepository;
	@Autowired private AutorRepository autorRepository;
	@Autowired private Converter converter;
	
	private static final Log LOGGER = LogFactory.getLog(PublicacionService.class);

	@Override
	public boolean create(PublicacionDTO publicacion) {
		boolean out = false;
		try {
			Autor autor = autorRepository.findById(publicacion.getIdAutor()).get();
		
			Publicacion entidad = new Publicacion();			
			entidad.setIdPublicacion(publicacion.getIdPublicacion());
			entidad.setTitulo(publicacion.getTitulo());
			entidad.setFechaPublicacion(publicacion.getFechaPublicacion());
			entidad.setAutor(autor);
			
			publicacionRepository.save(entidad);
			out = true;
		} catch (Exception e) {
			LOGGER.error("HUBO UN ERROR INSERTANDO LA PUBLICACION",e);
			out = false;
		}
		return out;
	}

	@Override
	public boolean delete(long id) {
		boolean out = true;
		try {

			Publicacion entity = publicacionRepository.findById(id).get();
			publicacionRepository.delete(entity);

		} catch (Exception e) {
			out = false;
			LOGGER.error("HUBO UN ERROR ELIMINANDO LA PUBLICACION",e);			
		}
		return out;
	}

	@Override
	public boolean update(long id, PublicacionDTO publicacion) {
		boolean out = true;
		try {
			Publicacion pub = publicacionRepository.findById(id).get();
			pub.setTitulo(publicacion.getTitulo());
			pub.setFechaPublicacion(publicacion.getFechaPublicacion());
			
			publicacionRepository.save(pub);

		} catch (Exception e) {
			out = false;
			LOGGER.error("ERROR AL ACTUALIZAR LA PUBLICACION",e);
		}
		return out;
	}

	@Override
	public List<PublicacionDTO> findAll() {
		List<PublicacionDTO> out = null;

		try {		
			out = converter.convertirPublicaciones(publicacionRepository.findAll());
		} catch (Exception e) {
			LOGGER.error("ERROR AL OBTENER TODAS LAS PUBLICACIONES",e);
		}
		
		return out;
	}

	@Override
	public PublicacionDTO findById(long id) {
		PublicacionDTO out = null;
		try {
			out = converter.convertirPublicacion(publicacionRepository.findById(id).get());
		} catch (Exception e) {
			LOGGER.error("ERRROR AL OBTENER UNA PUBLICACION",e);
		}
		return out;
	}

}
