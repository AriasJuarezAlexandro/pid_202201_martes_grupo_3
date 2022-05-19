package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Visita;

public interface VisitaService {
	public abstract List<Visita> listarVisitas();
	public abstract Visita registrarVisita(Visita visita);
}
