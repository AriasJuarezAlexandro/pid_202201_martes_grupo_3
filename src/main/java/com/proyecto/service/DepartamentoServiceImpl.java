package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Departamento;
import com.proyecto.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoRepository repository;
	
	@Override
	public List<Departamento> listaDepartamento() {
		return repository.findAll();
	}

	@Override
	public Departamento registrarDepartamento(Departamento departamento) {
		return repository.save(departamento);
	}

}
