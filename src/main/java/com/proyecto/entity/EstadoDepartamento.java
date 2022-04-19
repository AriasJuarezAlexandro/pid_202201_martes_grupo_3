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
@Table(name = "tb_estado_departamento")
public class EstadoDepartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEst;
	private String nomEst;
}
