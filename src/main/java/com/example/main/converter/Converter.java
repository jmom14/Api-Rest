package com.example.main.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.main.dto.AutorDTO;
import com.example.main.dto.NacionalidadDTO;
import com.example.main.dto.PublicacionDTO;
import com.example.main.entities.Autor;
import com.example.main.entities.Nacionalidad;
import com.example.main.entities.Publicacion;

@Component
public class Converter {
	
	public List<PublicacionDTO> convertirPublicaciones(List<Publicacion> lista){
		
		List<PublicacionDTO> out = new ArrayList<PublicacionDTO>();
		
		for(Publicacion p : lista) {
			PublicacionDTO tmpPublicacion = new PublicacionDTO();
			tmpPublicacion.setIdPublicacion(p.getIdPublicacion());
			tmpPublicacion.setTitulo(p.getTitulo());
			tmpPublicacion.setFechaPublicacion(p.getFechaPublicacion());
			tmpPublicacion.setIdAutor(p.getAutor().getIdAutor());
			
			out.add(tmpPublicacion);
		}
		return out;
	}
	
	public PublicacionDTO convertirPublicacion(Publicacion p) {
		
		PublicacionDTO tmpPublicacion = new PublicacionDTO();
		
		tmpPublicacion.setIdPublicacion(p.getIdPublicacion());
		tmpPublicacion.setTitulo(p.getTitulo());
		tmpPublicacion.setFechaPublicacion(p.getFechaPublicacion());
		tmpPublicacion.setIdAutor(p.getAutor().getIdAutor());
		
		return tmpPublicacion;
		
	}
	
	public List<NacionalidadDTO> convertirNacionalidades(List<Nacionalidad> nacionalidades){
		
		List<NacionalidadDTO> out = new ArrayList<>();
		
		for(Nacionalidad n : nacionalidades) {
			NacionalidadDTO tmpNacionalidad = new NacionalidadDTO();
			tmpNacionalidad.setIdNacionalidad(n.getIdNacionalidad());
			tmpNacionalidad.setNacionalidad(n.getNacionalidad());
			tmpNacionalidad.setPais(n.getPais());
			
			out.add(tmpNacionalidad);									
			
		}
		return out;
		
	}
	
	public NacionalidadDTO convertirNacionalidad(Nacionalidad nacionalidad) {
		
		NacionalidadDTO out = new NacionalidadDTO();
		
		out.setIdNacionalidad(nacionalidad.getIdNacionalidad());
		out.setNacionalidad(nacionalidad.getNacionalidad());
		out.setPais(nacionalidad.getPais());
		
		return out;
		
	}
	
	public List<AutorDTO> convertirAutores(List<Autor> autores){
		
		List<AutorDTO> out = new ArrayList<>();
		
		for(Autor a : autores) {
			
			AutorDTO tmpAutor = new AutorDTO();
			tmpAutor.setIdAutor(a.getIdAutor());
			tmpAutor.setNombre(a.getNombre());
			tmpAutor.setApellido(a.getApellido());
			tmpAutor.setFechaNacimiento(a.getFechaNacimiento());
			tmpAutor.setIdNacionalidad(a.getNacionalidad().getIdNacionalidad());
			
			out.add(tmpAutor);
		}
		return out;
	}
	
	public AutorDTO convertitAutor(Autor autor) {
		
		AutorDTO out = new AutorDTO();
		
		out.setIdAutor(autor.getIdAutor());
		out.setNombre(autor.getNombre());
		out.setApellido(autor.getApellido());
		out.setFechaNacimiento(autor.getFechaNacimiento());
		out.setIdNacionalidad(autor.getNacionalidad().getIdNacionalidad());
		
		return out;
		
	}

}
