package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Incidente;
import com.proyecto.repository.IncidenteRepository;

@Service
public class IncidenteServiceImpl implements IncidenteService{
	
	@Autowired
	private IncidenteRepository repository;
	
	@Override
	public List<Incidente> listaIncidentes() {
		return repository.findAll();
	}
	@Override
	public Incidente registrarIncidente(Incidente incidenteO) {
		return repository.save(incidenteO);
	}
	@Override
	public List<Incidente> validacionIncidente(int idIncidente, int idTipoIncidente) {
		return repository.validacionIncidente(idIncidente, idTipoIncidente);
	}
}
