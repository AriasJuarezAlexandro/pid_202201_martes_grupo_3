package com.proyecto.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.proyecto.entity.Usuario;

public interface UsuarioService{
	public abstract Usuario registrarUsuario(Usuario usuario);
}
