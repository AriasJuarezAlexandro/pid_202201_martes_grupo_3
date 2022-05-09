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

import lombok.Data;

@Data
@Entity
@Table(name = "tb_ocupante")
public class Ocupante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOcupante;
	private String nombres;
	private String apellidos;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_nacimiento;
	private int dni;
	private int telefono;
	@JoinColumn(name = "idPropietario")
	@ManyToOne
	private Propietario propietario;
	@ManyToOne
	@JoinColumn(name = "idAdmin")
	private Administrador administrador;
}