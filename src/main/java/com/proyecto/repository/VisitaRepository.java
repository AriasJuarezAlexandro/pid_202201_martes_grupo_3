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
	
	@Modifying
	@Transactional
	@Query("update Visita set estado = :p_estado , comentario = :p_comentario where idVisita = :p_idVisita")
	public void registrarSalida(@Param("p_idVisita") int id , 
								@Param("p_estado") int estado , 
								@Param("p_comentario") String comentario);
	

	@Query("select v from Visita v where v.visitante.dni = ?1 and v.estado = 0")
	public List<Visita> buscarVisitaPorVisitante(int dniVisitante);
}
