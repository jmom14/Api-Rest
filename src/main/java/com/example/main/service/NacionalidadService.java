package com.example.main.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.converter.Converter;
import com.example.main.dto.NacionalidadDTO;
import com.example.main.entities.Nacionalidad;
import com.example.main.repository.NacionalidadRepository;

@Service
public class NacionalidadService implements INacionalidadService {

	@Autowired
	private NacionalidadRepository nacionalidadRepository;
	
	@Autowired
	private Converter converter;
	
	private static final Log LOGGER = LogFactory.getLog(NacionalidadService.class);

	@Override
	public NacionalidadDTO create(NacionalidadDTO nacionalidad) {

		try {
			Nacionalidad entidad = new Nacionalidad();
			entidad.setNacionalidad(nacionalidad.getNacionalidad());
			entidad.setPais(nacionalidad.getPais());
			nacionalidadRepository.save(entidad);
			return nacionalidad;

		} catch (Exception e) {
			LOGGER.error("ERROR INSERTANDO NACIONALIDAD");
			return null;
		}

	}

	@Override
	public boolean delete(long id) {

		try {
			Nacionalidad n = nacionalidadRepository.findById(id).get();
			nacionalidadRepository.delete(n);
			return true;
		} catch (Exception e) {
			LOGGER.error("ERROR ELIMINANDO LA NACIONALIDAD", e);
			return false;
		}

	}

	@Override
	public boolean update(long id, NacionalidadDTO nacionalidad) {
		
		try {			
			Nacionalidad n = nacionalidadRepository.findById(id).get();
			n.setNacionalidad(nacionalidad.getNacionalidad());
			n.setPais(nacionalidad.getPais());
			nacionalidadRepository.save(n);
			return true;
			
		}catch(Exception e) {
			LOGGER.error("ERROR ACTUALIZANDO NACIONALIDAD");
			return false;
		}
		
	}

	@Override
	public List<NacionalidadDTO> findAll() {
		
		try {
			return converter.convertirNacionalidades(nacionalidadRepository.findAll());
			
		}catch(Exception e) {
			LOGGER.error("ERROR OBTENIENDO TODAS LAS NACIONALIDADES" , e);
			return null;
		}
	
	}

	@Override
	public NacionalidadDTO findById(long id) {

		try {
			return converter.convertirNacionalidad(nacionalidadRepository.findById(id).get());
			
		}catch(Exception e) {
			LOGGER.error("ERROR OBTENIENDO TODAS LAS NACIONALIDADES" , e);
			return null;
			
		}
	}

}
