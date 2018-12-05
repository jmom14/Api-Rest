package com.example.main.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "NACIONALIDAD")
public class Nacionalidad implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_NACIONALIDAD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idNacionalidad;
	
	@Column(name="PAIS")
	private String pais;
	
	@Column(name="NACIONALIDAD")
	private String nacionalidad;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "nacionalidad")
	private List<Autor> autores = new ArrayList<Autor>();

	public long getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(long idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	

}
