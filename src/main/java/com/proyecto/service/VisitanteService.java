package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Visitante;

public interface VisitanteService {
	public List<Visitante> listaVisitante();
	public Visitante insertaActualizaVisitante(Visitante obj);
}
