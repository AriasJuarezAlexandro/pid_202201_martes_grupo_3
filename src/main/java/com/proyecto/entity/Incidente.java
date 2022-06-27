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
@Table(name = "tb_incidente")
public class Incidente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idIncidente;
	@ManyToOne
	@JoinColumn(name = "idDepartamento")
	Departamento departamento;
	@ManyToOne
	@JoinColumn(name = "idTipoIncidente")
	TipoIncidente tipoIncidente;
	@ManyToOne
	@JoinColumn(name = "idAdmin")
	private Administrador administrador;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fecha_registro;
	String comentario;
	int estado;
}
