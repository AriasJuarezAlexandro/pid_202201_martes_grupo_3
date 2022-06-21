package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import com.proyecto.entity.Boleta;

public interface BoletaRepository extends JpaRepository<Boleta, Integer>{
	@Query("select b from Boleta b where"
			+ "(:p_dni is '' or b.propietario.dni LIKE :p_dni) and"
			+ "(:p_nombre is '' or b.propietario.nombres LIKE :p_nombre) and"
			+ "(b.estado = :p_estado) and"
			+ "(b.servicio.idServicio = :p_servicio)")
	public List<Boleta> filtroBoleta(
			@Param("p_dni") String dni ,
			@Param("p_nombre") String nombre , 
			@Param("p_estado") int estado ,
			@Param("p_servicio") int servicio);
	
	@Query("select b from Boleta b where"
			+ "(:p_dni is '' or b.propietario.dni LIKE :p_dni) and"
			+ "(:p_nombre is '' or b.propietario.nombres LIKE :p_nombre) and"
			+ "(b.estado = :p_estado)")
	public List<Boleta> filtroBoletaSinServicio(
			@Param("p_dni") String dni ,
			@Param("p_nombre") String nombre , 
			@Param("p_estado") int estado);
	
	@Query("select b from Boleta b where"
			+ "(:p_dni is '' or b.propietario.dni LIKE :p_dni) and"
			+ "(:p_nombre is '' or b.propietario.nombres LIKE :p_nombre) and"
			+ "(b.servicio.idServicio = :p_servicio)")
	public List<Boleta> filtroBoletaSinEstado(
			@Param("p_dni") String dni ,
			@Param("p_nombre") String nombre , 
			@Param("p_servicio") int servicio);
	
	@Query("select b from Boleta b where"
			+ "(:p_dni is '' or b.propietario.dni LIKE :p_dni) and"
			+ "(:p_nombre is '' or b.propietario.nombres LIKE :p_nombre)")
	public List<Boleta> filtroBoletaSinEstadoSinServicio(
			@Param("p_dni") String dni ,
			@Param("p_nombre") String nombre);
	
	@Modifying
	@Transactional
	@Query("update Boleta set estado = :p_estado where idBoleta = :p_idBoleta")
	public void pagoBoleta(@Param("p_idBoleta") int id , @Param("p_estado") int estado);
	
	@Query("SELECT b from Boleta b where b.propietario.idPropietario = ?1 and b.mes = ?2 and b.servicio.idServicio = ?3")
	public Boleta buscarBoletasPorPropietario(int idPropietario , int mes , int idServicio);
}
