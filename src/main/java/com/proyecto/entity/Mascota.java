package com.proyecto.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMascota;
	private String nombre;
	private String especie;
	private String raza;
	@ManyToOne
	@JoinColumn(name = "idPropietario")
	private Propietario propietario;
	@ManyToOne
	@JoinColumn(name = "idAdmin")
	private Administrador administrador;
}
