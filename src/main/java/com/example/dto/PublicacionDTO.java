package com.example.dto;

import java.io.Serializable;
import java.util.Date;

public class PublicacionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long idPublicacion;
	private String titulo;
	private Date fechaPublicacion;
	private String autor;

	public long getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(long idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	

}
