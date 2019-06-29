package com.example.main.service;

import java.util.List;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.main.converter.Converter;
import com.example.main.dto.PublicationDTO;
import com.example.main.entities.Author;
import com.example.main.entities.Publication;
import com.example.main.repository.AuthorRepository;
import com.example.main.repository.PublicationRepository;
import com.example.main.service.abstrct.IPublicationService;

@Service
public class PublicationService implements IPublicationService{


	@Autowired
	private PublicationRepository publicacionRepository;
	
	@Autowired
	private AuthorRepository autorRepository;
	
	@Autowired
	private Converter converter;

	private static final Log LOGGER = LogFactory.getLog(PublicationService.class);

	@Override
	public PublicationDTO create(PublicationDTO publicacion) {
		try {
			long num = 1;
			Author author = autorRepository.findById(num).get();
			Publication entidad = new Publication(publicacion, author);
			publicacionRepository.save(entidad);
			return publicacion;
		} catch (Exception e) {
			LOGGER.error("HUBO UN ERROR INSERTANDO LA PUBLICACION", e);
			return null;
		}
	}

	@Override
	public boolean delete(long id) {
		try {
			Publication entity = publicacionRepository.findById(id).get();
			publicacionRepository.delete(entity);
			return true;
		} catch (Exception e) {
			LOGGER.error("HUBO UN ERROR ELIMINANDO LA PUBLICACION", e);
			return false;
		}
	}

	@Override
	public boolean update(PublicationDTO publicacion, long id) {
		boolean out = true;
		try {
			Publication pub = publicacionRepository.findById(id).get();
			pub.setTitle(publicacion.getTitle());
			pub.setPublicationDate(publicacion.getPublicationDate());
			publicacionRepository.save(pub);
		} catch (Exception e) {
			out = false;
			LOGGER.error("ERROR AL ACTUALIZAR LA PUBLICACION", e);
		}
		return out;
	}

	@Override
	public List<PublicationDTO> findAll() {
		try {
			return converter.convertirPublicaciones(publicacionRepository.findAll());
		} catch (Exception e) {
			LOGGER.error("ERROR AL OBTENER TODAS LAS PUBLICACIONES", e);
			return null;
		}
	}

	@Override
	public PublicationDTO findById(long id) {
		try {
			return converter.convertirPublicacion(publicacionRepository.findById(id).get());
		} catch (Exception e) {
			LOGGER.error("ERRROR AL OBTENER UNA PUBLICACION", e);
			return null;
		}
	}

	@Override
	public List<PublicationDTO> getPaged(Pageable pageable) {
		return converter.convertirPublicaciones(publicacionRepository.findAll(pageable).getContent());
	}

}
