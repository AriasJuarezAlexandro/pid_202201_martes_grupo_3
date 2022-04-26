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
	public List<Ocupante> listaOcupantes() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Ocupante insertaActualizaOcupantes(Ocupante obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}
	
}
