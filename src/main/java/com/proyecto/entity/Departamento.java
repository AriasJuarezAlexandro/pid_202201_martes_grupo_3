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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartamento;
	@Range(min = 25 , message = "Este campo no puede estar vacio.")
	private double metros;
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(min=5,max=40 , message = "La direccion debe ser entre 5 y 40 caracteres")
	private String direccion;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fecha_registro;
	@ManyToOne
	@JoinColumn(name = "idTipo")
	private TipoDepartamento tipoDepartamento;
	@ManyToOne
	@JoinColumn(name = "idEdificio")
	private Edificio edificio;
	private int estado;
	@ManyToOne
	@JoinColumn(name = "idAdmin")
	private Administrador administrador;
}
