package com.example.main.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="AUTOR")
public class Autor implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_AUTOR")
	private long idAutor;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="APELLIDO")
	private String apellido;
	
	@Column(name="FECHA_NACIMIENTO")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	
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
	
	

}
