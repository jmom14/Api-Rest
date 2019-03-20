package com.example.main.dto;

import java.io.Serializable;
import java.util.Date;


public class AutorDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long idAutor;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Long idNacionalidad;
	
	
	public long getIdAutor() {
		return idAutor;
	}
	
	public void setIdAutor(long idAutor) {
		this.idAutor = idAutor;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public long getIdNacionalidad() {
		return idNacionalidad;
	}
	
	public void setIdNacionalidad(long idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}
	
	
	
}
