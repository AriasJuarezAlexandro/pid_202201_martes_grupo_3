package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Propietario;

public interface PropietarioService {
	public List<Propietario> listaPropietario();
	public Propietario insertaActualizaPropietario(Propietario obj);

}
