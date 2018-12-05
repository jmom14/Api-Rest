package com.example.main.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.main.dto.NacionalidadDTO;
import com.example.main.dto.PublicacionDTO;
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

}
