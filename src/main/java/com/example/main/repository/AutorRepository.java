package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.main.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
