package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
	public abstract Administrador findByDni(String dni);
	public abstract Administrador findByEmail(String email);
}
