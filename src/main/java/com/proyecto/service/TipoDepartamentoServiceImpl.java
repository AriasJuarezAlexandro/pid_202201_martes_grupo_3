package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.TipoDepartamento;
import com.proyecto.repository.TipoDepartamentoRepository;

@Service
public class TipoDepartamentoServiceImpl implements TipoDepartamentoService{

	@Autowired
	private TipoDepartamentoRepository repository;
	
	@Override
	public List<TipoDepartamento> listaTipoDepartamento() {
		return repository.findAll();
	}

}
