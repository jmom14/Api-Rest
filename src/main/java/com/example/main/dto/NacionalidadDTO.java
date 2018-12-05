package com.example.main.dto;

import java.io.Serializable;

public class NacionalidadDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long idNacionalidad;
	private String nacionalidad;
	private String pais;
	
	public NacionalidadDTO() {
	}	
	
	public NacionalidadDTO(long idNacionalidad, String nacionalidad, String pais) {
		super();
		this.idNacionalidad = idNacionalidad;
		this.nacionalidad = nacionalidad;
		this.pais = pais;
	}
	
	public long getIdNacionalidad() {
		return idNacionalidad;
	}
	
	public void setIdNacionalidad(long idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	

}
