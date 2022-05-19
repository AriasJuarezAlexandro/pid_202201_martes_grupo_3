package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Visita;
import com.proyecto.repository.VisitaRepository;

@Service
public class VisitaServiceImpl implements VisitaService{

	@Autowired
	private VisitaRepository repository;
	
	@Override
	public List<Visita> listarVisitas() {
		return repository.findAll();
	}

	@Override
	public Visita registrarVisita(Visita visita) {
		return repository.save(visita);
	}

}
