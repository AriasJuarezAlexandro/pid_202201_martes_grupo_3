package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Propietario;
import com.proyecto.repository.PropietarioRepository;

@Service
public class PropietarioServiceImpl implements PropietarioService{

	@Autowired
	private PropietarioRepository repository;
	
	@Override
	public Propietario registrarPropietario(Propietario propietario) {
		return repository.save(propietario);
	}

	@Override
	public List<Propietario> listarPropietarios() {
		return repository.findAll();
	}

	@Override
	public Optional<Propietario> buscarPorId(int id) {
		return repository.findById(id);
	}

}
