package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Propietario;

public interface PropietarioService {
	public abstract List<Propietario> listaPropietario();
	public abstract Propietario insertaActualizaPropietario(Propietario obj);

}
