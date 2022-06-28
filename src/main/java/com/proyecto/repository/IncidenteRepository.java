package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Incidente;

public interface IncidenteRepository extends JpaRepository<Incidente, Integer>{
	@Query("select i from Incidente i where i.departamento.idDepartamento =?1 and i.tipoIncidente.idTipoIncidente = ?2 and i.estado = 0")
	public List<Incidente> validacionIncidente(int idDepartamento , int idTipoIncidente);
}
