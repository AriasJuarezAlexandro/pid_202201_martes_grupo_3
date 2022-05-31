package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Ocupante;

public interface OcupanteRepository extends JpaRepository<Ocupante, Integer>{
	public Ocupante findByDni(int dni);
}
