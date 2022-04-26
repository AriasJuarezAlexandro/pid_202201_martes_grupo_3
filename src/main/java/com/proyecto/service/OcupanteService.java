package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Ocupante;
import com.proyecto.entity.Visitante;

public interface OcupanteService {
	public List<Ocupante> listaOcupantes();
	public Ocupante insertaActualizaOcupantes(Ocupante obj);

}
