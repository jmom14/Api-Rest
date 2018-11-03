package com.example.main.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.main.entities.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Serializable>{
	
	public Publicacion findByIdPublicacion(long idPublicacion);
	
	public List<Publicacion> findAll();

}
