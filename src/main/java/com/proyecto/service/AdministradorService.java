package com.proyecto.service;

import com.proyecto.entity.Administrador;

public interface AdministradorService {
	public abstract Administrador registrarAdministrador(Administrador administrador) throws Exception;
	public abstract Administrador buscarAdministradorPorDni(String dni) throws Exception;
	public abstract Administrador buscarAdministradorPorEmail(String email) throws Exception;
}
