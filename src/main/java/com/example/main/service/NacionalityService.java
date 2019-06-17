package com.example.main.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.converter.Converter;
import com.example.main.dto.NacionalityDTO;
import com.example.main.entities.Nacionality;
import com.example.main.repository.NacionalidadRepository;
import com.example.main.service.abstrct.INacionalityService;

@Service
public class NacionalityService implements INacionalityService{

	@Autowired
	private NacionalidadRepository nacionalidadRepository;
	
	@Autowired
	private Converter converter;
	
	private static final Log LOGGER = LogFactory.getLog(NacionalityService.class);

	@Override
	public NacionalityDTO create(NacionalityDTO nacionalityDto) {
		try {
			Nacionality entidad = new Nacionality(nacionalityDto);
			nacionalidadRepository.save(entidad);
			return nacionalityDto;
		} catch (Exception e) {
			LOGGER.error("ERROR INSERTANDO NACIONALIDAD");
			return null;
		}
	}

	@Override
	public boolean delete(long id) {
		try {
			Nacionality n = nacionalidadRepository.findById(id).get();
			nacionalidadRepository.delete(n);
			return true;
		} catch (Exception e) {
			LOGGER.error("ERROR ELIMINANDO LA NACIONALIDAD", e);
			return false;
		}
	}

	@Override
	public boolean update(NacionalityDTO nacionality, long id) {
		try {			
			Nacionality n = nacionalidadRepository.findById(id).get();
			n.setNacionality(nacionality.getNacionality());
			n.setCountry(nacionality.getCountry());
			nacionalidadRepository.save(n);
			return true;
		}catch(Exception e) {
			LOGGER.error("ERROR ACTUALIZANDO NACIONALIDAD");
			return false;
		}
	}

	@Override
	public List<NacionalityDTO> findAll() {
		try {
			return converter.convertirNacionalidades(nacionalidadRepository.findAll());
			
		}catch(Exception e) {
			LOGGER.error("ERROR OBTENIENDO TODAS LAS NACIONALIDADES" , e);
			return null;
		}
	}

	@Override
	public NacionalityDTO findById(long id) {
		try {
			return converter.convertirNacionalidad(nacionalidadRepository.findById(id).get());
		}catch(Exception e) {
			LOGGER.error("ERROR OBTENIENDO TODAS LAS NACIONALIDADES" , e);
			return null;
		}
	}
}
