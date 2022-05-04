package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.DistritoEdificio;
import com.proyecto.repository.DistritoEdificioRepository;

@Service
public class DistritoEdificioServiceImpl implements DistritoEdificioService{

	@Autowired
	private DistritoEdificioRepository repository;
	
	@Override
	public List<DistritoEdificio> listaDistritos() {
		return repository.findAll();
	}

}
