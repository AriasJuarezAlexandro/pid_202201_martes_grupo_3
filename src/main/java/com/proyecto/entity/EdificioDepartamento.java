package com.proyecto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tb_edificio_departamento")
public class EdificioDepartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEdificio;
	private String nomEdificio;
}
