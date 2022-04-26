package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Visitante;

public interface VisitanteService {
	
	public abstract List<Visitante> listaVisitante();
	public abstract Visitante insertaActualizaVisitante(Visitante obj);
}
