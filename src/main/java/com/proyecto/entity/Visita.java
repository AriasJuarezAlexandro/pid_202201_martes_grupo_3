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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_visitas")
public class Visita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVisita;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fecha_entrada;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fecha_salida;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fecha_registro;
	@ManyToOne
	@JoinColumn(name = "idVisitante")
	private Visitante visitante;
	@ManyToOne
	@JoinColumn(name = "idPropietario")
	private Propietario propietario;
	@ManyToOne
	@JoinColumn(name = "idAdmin")
	private Administrador administrador;
	private int estado;
	private String comentario;
}
