package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.entity.Propietario;

public interface PropietarioService {
	public abstract Propietario registrarPropietario(Propietario propietario);
	public abstract List<Propietario> listarPropietarios();
	public abstract Optional<Propietario> buscarPorId(int id);
	public Propietario buscarPorDni(int id);
}
