package com.example.main.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.main.dto.PublicacionDTO;
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
			tmpPublicacion.setAutor(p.getAutor().getNombre());
			
			out.add(tmpPublicacion);
		}
		return out;
	}
	
	public PublicacionDTO convertirPublicacion(Publicacion p) {
		
		PublicacionDTO tmpPublicacion = new PublicacionDTO();
		
		tmpPublicacion.setIdPublicacion(p.getIdPublicacion());
		tmpPublicacion.setTitulo(p.getTitulo());
		tmpPublicacion.setFechaPublicacion(p.getFechaPublicacion());
		tmpPublicacion.setAutor(p.getAutor().getNombre());
		
		return tmpPublicacion;
		
	}

}
