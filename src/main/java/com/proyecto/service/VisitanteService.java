package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Visitante;

public interface VisitanteService {
	public abstract Visitante registrarVisitante(Visitante visitante);
	public abstract List<Visitante> listarVisitantes();
}
