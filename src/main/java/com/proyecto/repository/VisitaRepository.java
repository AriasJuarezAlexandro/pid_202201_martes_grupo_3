package com.proyecto.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.entity.Visita;

public interface VisitaRepository extends JpaRepository<Visita, Integer>{

	@Query("select v from Visita v where"
			+ "(:p_dni is '' or v.visitante.dni LIKE :p_dni) and"
			+ "(:p_nombre is '' or v.visitante.nombres LIKE :p_nombre) and"
			+ "(v.estado = :p_estado)")
	public List<Visita> listaVisitaPorDniNombreEstado(
			@Param("p_dni") String dni ,
			@Param("p_nombre") String nombre , 
			@Param("p_estado") int estado);
}
