package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Mascota;
import com.proyecto.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService{

	@Autowired
	private MascotaRepository repository;
	
	@Override
	public Mascota registrarMascota(Mascota mascota) {
		return repository.save(mascota);
	}

	@Override
	public List<Mascota> listarMascotas() {
		return repository.findAll();
	}

}
