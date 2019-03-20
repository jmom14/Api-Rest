package com.example.main.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.main.entities.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

	Page<Publicacion> findAll(Pageable pageable);
	
}
