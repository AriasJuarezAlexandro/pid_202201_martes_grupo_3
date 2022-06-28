package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Incidente;

public interface IncidenteService {
	public abstract List<Incidente> listaIncidentes();
	public abstract Incidente registrarIncidente(Incidente incidenteO);
	public abstract void cambiarEstado(int idIncidente , int estado);
	public abstract List<Incidente> validacionIncidente(int idIncidente, int idTipoIncidente);
}
