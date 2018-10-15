package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name= "DEPARTAMENTO")
@Entity
public class Departamento {
	
	@Id
	@Column(name="ID_DEPARTAMENTO")
	private Integer idDepartamento;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	public Departamento() {
		super();
	}

	public Departamento(Integer idDepartamento, String nombre) {
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}



	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
