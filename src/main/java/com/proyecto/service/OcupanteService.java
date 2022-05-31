package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Ocupante;

public interface OcupanteService {
	public abstract Ocupante registrarOcupante(Ocupante ocupante);
	public abstract List<Ocupante> listarOcupantes();
	public Ocupante buscarPorDni(int dni);
}
