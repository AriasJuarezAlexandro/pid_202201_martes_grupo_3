package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Incidente;

public interface IncidenteRepository extends JpaRepository<Incidente, Integer>{

}
