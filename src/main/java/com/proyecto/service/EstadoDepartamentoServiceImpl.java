package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.EstadoDepartamento;
import com.proyecto.repository.EstadoDepartamentoRepository;

@Service
public class EstadoDepartamentoServiceImpl implements EstadoDepartamentoService{

	@Autowired
	private EstadoDepartamentoRepository repository;
	
	@Override
	public List<EstadoDepartamento> listaEstadoDepartamento() {
		return repository.findAll();
	}
}
