package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Ocupante;
import com.proyecto.entity.Visitante;

public interface OcupanteService {
	public abstract List<Ocupante> listaOcupantes();
	public abstract Ocupante insertaActualizaOcupantes(Ocupante obj);

}
