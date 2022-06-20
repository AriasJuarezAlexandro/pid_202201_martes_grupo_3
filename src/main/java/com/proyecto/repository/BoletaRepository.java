package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Boleta;

public interface BoletaRepository extends JpaRepository<Boleta, Integer>{
	@Query("SELECT b from Boleta b where b.propietario.idPropietario = ?1 and b.mes = ?2 and b.servicio.idServicio = ?3")
	public Boleta buscarBoletasPorPropietario(int idPropietario , int mes , int idServicio);
}
