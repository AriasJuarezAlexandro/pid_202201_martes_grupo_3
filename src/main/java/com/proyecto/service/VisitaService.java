package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Visita;

public interface VisitaService {
	public abstract List<Visita> listarVisitas();
	public abstract Visita registrarVisita(Visita visita);
	public List<Visita> listaVisitaFiltro(String dni , String nombre , int estado);
	public void registrarSalidaVisita(int idVisita , int estado , String comentario);
	public List<Visita> buscarVisitasPorVisitante(int dniVisitante);
}
