package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	
	@Modifying
	@Transactional
	@Query("update Departamento set estado =:estado where idDepartamento =:id")
	public void actualizarEstado(int id , int estado);
	
	@Modifying
	@Transactional
	@Query("update Departamento set tipoDepartamento.idTipo =:tipo where idDepartamento =:id")
	public void actualizarTipo(int id , int tipo);
	
	@Query("SELECT d FROM Departamento d where d.estado = 1 and d.tipoDepartamento = 1")
	public List<Departamento> findAll();
}
