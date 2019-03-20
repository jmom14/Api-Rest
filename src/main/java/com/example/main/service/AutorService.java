package com.example.main.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.converter.Converter;
import com.example.main.dto.AutorDTO;
import com.example.main.entities.Autor;
import com.example.main.entities.Nacionalidad;
import com.example.main.repository.AutorRepository;
import com.example.main.repository.NacionalidadRepository;

@Service
public class AutorService implements IAutorService{
	
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private NacionalidadRepository nacionalidadRepository;  
	@Autowired
	private Converter converter;

	private static final Log LOGGER = LogFactory.getLog(AutorService.class);
	
	@Override
	public AutorDTO create(AutorDTO autor) {
		
		try {			
			Nacionalidad nac = nacionalidadRepository.findById(autor.getIdNacionalidad()).get();
			
			Autor entidad = new Autor();
			entidad.setNombre(autor.getNombre());
			entidad.setApellido(autor.getApellido());
			entidad.setFechaNacimiento(autor.getFechaNacimiento());
			entidad.setNacionalidad(nac);
			
			autorRepository.save(entidad);
					
			return autor;						
		}catch(Exception e) {			
			LOGGER.error("HUBO UN ERROR INSERTANDO EL AUTOR", e);
			return null;
		}
		
	}

	@Override
	public boolean delete(long id) {
		
		try {
			
			Autor entidad = autorRepository.findById(id).get();
			autorRepository.delete(entidad);
			
			return true;
		}catch(Exception e) {
			LOGGER.error("HUBO UN ERROR ELIMINANDO EL AUTOR", e);
			return false;
		}

	}

	@Override
	public boolean update(long id, AutorDTO autor) {
		
		try {
		
		Autor entidad = autorRepository.findById(id).get();
		Nacionalidad nac = nacionalidadRepository.findById(autor.getIdAutor()).get();
		
		entidad.setNombre(autor.getNombre());
		entidad.setApellido(autor.getApellido());
		entidad.setFechaNacimiento(autor.getFechaNacimiento());
		entidad.setNacionalidad(nac);
		
		autorRepository.save(entidad);
		return true;
		
		}catch(Exception e) {
			LOGGER.error("HUBO UN ERROR ACTUALIZANDO EL AUTOR", e);
		}
		return false;
	}

	@Override
	public List<AutorDTO> findAll() {
		try {
			return converter.convertirAutores(autorRepository.findAll());
		}catch(Exception e) {
			LOGGER.error("ERROR AL OBTENER TODOS LOS AUTORES", e);
			return null;
		}
	}

	@Override
	public AutorDTO findById(long id) {
		
		try {
			return converter.convertitAutor(autorRepository.findById(id).get());
		}catch(Exception e) {
			LOGGER.error("ERROR AL OBTENER TODOS LOS AUTORES", e);
			return null;
		}
	}

}
