package com.example.main.converter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.main.dto.AuthorDTO;
import com.example.main.dto.NacionalityDTO;
import com.example.main.dto.PublicationDTO;
import com.example.main.entities.Author;
import com.example.main.entities.Nacionality;
import com.example.main.entities.Publication;

@Component
public class Converter {
	
	public List<PublicationDTO> convertirPublicaciones(List<Publication> publications){
		return publications.stream().map(PublicationDTO::new).collect(Collectors.toList());
	}
	
	public PublicationDTO convertirPublicacion(Publication publication) {
		return new PublicationDTO(publication);
	}
	
	public List<NacionalityDTO> convertirNacionalidades(List<Nacionality> nacionalities){
		return nacionalities.stream().map(NacionalityDTO::new).collect(Collectors.toList());		
	}
	
	public NacionalityDTO convertirNacionalidad(Nacionality nacionality) {
		return new NacionalityDTO(nacionality);
	}
	
	public List<AuthorDTO> convertirAutores(List<Author> authores){
		return authores.stream().map(AuthorDTO::new).collect(Collectors.toList());
	}
	
	public AuthorDTO convertitAutor(Author author) {
		return new AuthorDTO(author);
	}
}