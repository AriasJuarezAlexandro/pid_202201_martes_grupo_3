package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Edificio;
import com.proyecto.repository.EdificioRepository;

@Service
public class EdificioServiceImpl implements EdificioService{
	
	@Autowired
	private EdificioRepository repository;
	
	@Override
	public List<Edificio> listaEdificios() {
		return repository.findAll();
	}

	@Override
	public Edificio registrarEdificio(Edificio edificio) {
		return repository.save(edificio);
	}

}
