package com.proyecto.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Incidente;

public interface IncidenteRepository extends JpaRepository<Incidente, Integer> {
	@Query("select i from Incidente i where i.departamento.idDepartamento =?1 and i.tipoIncidente.idTipoIncidente = ?2 and i.estado = 0")
	public List<Incidente> validacionIncidente(int idDepartamento, int idTipoIncidente);

	@Modifying
	@Transactional
	@Query("update Incidente set estado = ?2 where idIncidente = ?1")
	public void atenderIncidente(int idIncidente , int estado);
	
	// Filtros
	@Query("select i from Incidente i where i.departamento.idDepartamento = ?1 and i.tipoIncidente.idTipoIncidente = ?2")
	public List<Incidente> filtroDepartamentoTipo(int idDepartamento, int idTipo);

	@Query("select i from Incidente i where i.tipoIncidente.idTipoIncidente = ?1 and i.estado = ?2")
	public List<Incidente> filtrTipoEstado(int idTipo, int estado);

	@Query("select i from Incidente i where i.departamento.idDepartamento = ?1 and i.estado = ?2")
	public List<Incidente> filtroDepartamentoEstado(int idDepartamento, int estado);

	@Query("select i from Incidente i where i.departamento.idDepartamento = ?1")
	public List<Incidente> filtroDepartamento(int idDepartamento);

	@Query("select i from Incidente i where i.tipoIncidente.idTipoIncidente = ?1")
	public List<Incidente> filtroTipo(int idTipo);

	@Query("select i from Incidente i where i.estado = ?1")
	public List<Incidente> filtroEstado(int estado);

	@Query("select i from Incidente i where i.departamento.idDepartamento = ?1 and i.tipoIncidente.idTipoIncidente = ?2 and i.estado = ?3")
	public List<Incidente> filtro(int idDepartamento, int idTipo, int estado);
}
