package com.example.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PUBLICACION")
public class Publicacion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PUBLICACION")
	private long idPublicacion;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="FECHA_PUBLICACION")
	private Date fechaPublicacion;
	
	@Column(name="AUTOR")
	private Autor autor;

	public Publicacion(long idPublicacion, String titulo, Date fechaPublicacion, Autor autor) {
		this.idPublicacion = idPublicacion;
		this.titulo = titulo;
		this.fechaPublicacion = fechaPublicacion;
		this.autor = autor;
	}

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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	

}
