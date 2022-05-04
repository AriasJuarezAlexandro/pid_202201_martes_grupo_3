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
@Table(name = "tb_edificio")
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEdificio;
	private String nombre;
	private String npisos;
	@ManyToOne
	@JoinColumn(name = "id_dis")
	private DistritoEdificio distrito;
	private String direccion;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fech_const;
	@ManyToOne
	@JoinColumn(name = "idAdmin")
	private Administrador administrador;
}
