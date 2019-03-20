package com.example.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.main.entities.Usuario;
import com.example.main.repository.UsuarioRepository;

public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		Usuario us = usuarioRepository.findByUsuario(usuario);

		return new User(us.getUsuario(), us.getContrasena(), us.isActivo(), us.isActivo(), us.isActivo(), us.isActivo(),
				buildGranted(us.getRol()));
	}

	public List<GrantedAuthority> buildGranted(byte rol) {

		String[] roles = { "LECTOR", "USUARIO", "ADMINISTRADOR" };
		List<GrantedAuthority> auths = new ArrayList<>();

		for (int i = 0; i < rol; i++) {
			auths.add(new SimpleGrantedAuthority(roles[i]));
		}
		return auths;
	}

}
