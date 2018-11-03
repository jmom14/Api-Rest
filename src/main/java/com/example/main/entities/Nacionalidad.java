package com.example.main.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Nacionalidad implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_NACIONALIDAD")
	private long idNacionalidad;
	
	@Column(name="PAIS")
	private String pais;
	
	@Column(name="NACIONALIDAD")
	private String nacionalidad;

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
	
	

}
