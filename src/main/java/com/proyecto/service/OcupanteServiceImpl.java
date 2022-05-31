package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Ocupante;
import com.proyecto.repository.OcupanteRepository;

@Service
public class OcupanteServiceImpl implements OcupanteService{
	@Autowired
	private OcupanteRepository repository;
	
	@Override
	public Ocupante registrarOcupante(Ocupante ocupante) {
		return repository.save(ocupante);
	}

	@Override
	public List<Ocupante> listarOcupantes() {
		return repository.findAll();
	}

	@Override
	public Ocupante buscarPorDni(int dni) {
		return repository.findByDni(dni);
	}

}
