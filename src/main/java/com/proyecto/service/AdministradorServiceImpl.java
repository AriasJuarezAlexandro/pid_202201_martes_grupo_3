package com.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Administrador;
import com.proyecto.repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService{

	@Autowired
	private AdministradorRepository repository;
	
	@Override
	public Administrador registrarAdministrador(Administrador administrador) {
		return repository.save(administrador);
	}

	@Override
	public Administrador buscarAdministradorPorDni(String dni) throws Exception {
		return repository.findByDni(dni);
	}

	@Override
	public Administrador buscarAdministradorPorEmail(String email) throws Exception {
		return repository.findByEmail(email);
	}

}
