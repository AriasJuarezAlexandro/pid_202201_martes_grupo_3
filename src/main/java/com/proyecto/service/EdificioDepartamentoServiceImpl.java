package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.EdificioDepartamento;
import com.proyecto.repository.EdificioDepartamentoRepository;

@Service
public class EdificioDepartamentoServiceImpl implements EdificioDepartamentoService{

	@Autowired
	private EdificioDepartamentoRepository repository;
	
	@Override
	public List<EdificioDepartamento> listaEdificioDepartamento() {
		return repository.findAll();
	}

}
