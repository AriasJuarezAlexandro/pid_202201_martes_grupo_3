package com.proyecto.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.proyecto.entity.Administrador;

public interface AdministradorService extends UserDetailsService{
	public abstract Administrador registrarAdministrador(Administrador administrador);
}
