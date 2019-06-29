package com.example.main.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.converter.Converter;
import com.example.main.dto.AuthorDTO;
import com.example.main.entities.Author;
import com.example.main.entities.Nacionality;
import com.example.main.repository.AuthorRepository;
import com.example.main.repository.NacionalityRepository;
import com.example.main.service.abstrct.IAuthorService;

@Service
public class AuthorService implements IAuthorService {

	@Autowired
	private AuthorRepository autorRepository;
	@Autowired
	private NacionalityRepository nacionalidadRepository;
	@Autowired
	private Converter converter;

	private static final Log LOGGER = LogFactory.getLog(AuthorService.class);

	@Override
	public AuthorDTO create(AuthorDTO authorDto) {
		try {
			Nacionality nac = nacionalidadRepository.findById(authorDto.getNacionalityId()).get();
			Author author = new Author(authorDto, nac);
			autorRepository.save(author);
			return authorDto;
		} catch (Exception e) {
			LOGGER.error("HUBO UN ERROR INSERTANDO EL AUTOR", e);
			return null;
		}
	}

	@Override
	public boolean delete(long id) {
		try {
			Author entidad = autorRepository.findById(id).get();
			autorRepository.delete(entidad);
			return true;
		} catch (Exception e) {
			LOGGER.error("HUBO UN ERROR ELIMINANDO EL AUTOR", e);
			return false;
		}
	}

	@Override
	public boolean update(AuthorDTO autorDto, long id) {
		try {
			Author author = autorRepository.findById(id).get();
			Nacionality nac = nacionalidadRepository.findById(autorDto.getIdAutor()).get();

			author.setName(autorDto.getName());
			author.setLastname(autorDto.getLastname());
			author.setBirthDate(autorDto.getBirthDate());
			author.setNacionality(nac);
			autorRepository.save(author);
			return true;
		} catch (Exception e) {
			LOGGER.error("HUBO UN ERROR ACTUALIZANDO EL AUTOR", e);
		}
		return false;
	}

	@Override
	public List<AuthorDTO> findAll() {
		try {
			return converter.convertirAutores(autorRepository.findAll());
		} catch (Exception e) {
			LOGGER.error("ERROR AL OBTENER TODOS LOS AUTORES", e);
			return null;
		}
	}

	@Override
	public AuthorDTO findById(long id) {

		try {
			return converter.convertitAutor(autorRepository.findById(id).get());
		} catch (Exception e) {
			LOGGER.error("ERROR AL OBTENER TODOS LOS AUTORES", e);
			return null;
		}
	}
}