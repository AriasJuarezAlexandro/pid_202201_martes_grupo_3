package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Propietario;
import com.proyecto.repository.PropietarioRepository;

@Service
public class PropietarioServiceImpl implements PropietarioService{

	@Autowired
	private PropietarioRepository repository;
	

	@Override
	public List<Propietario> listaPropietario() {
		return repository.findAll();
	}


	@Override
	public Propietario insertaActualizaPropietario(Propietario obj) {
		return repository.save(obj);
	}

}
