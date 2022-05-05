package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Propietario;

public interface PropietarioService {
	public abstract Propietario registrarPropietario(Propietario propietario);
	public abstract List<Propietario> listarPropietarios();
}
