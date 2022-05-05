package com.proyecto.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_propietario")
public class Propietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPropietario;
	private String nombres;
	private String apellidos;
	private int dni;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_nacimiento;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fecha_registro;
	private int telefono;
	@ManyToOne
	@JoinColumn(name = "idDepartamento")
	private Departamento departamento;
	private int estado;
	@ManyToOne
	@JoinColumn(name = "idAdmin")
	private Administrador administrador;
}
