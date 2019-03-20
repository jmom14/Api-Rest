package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByUsuario(String usuario);

}
