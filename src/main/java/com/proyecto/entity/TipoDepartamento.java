package com.proyecto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_tipo_departamento")
public class TipoDepartamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipo;
	private String nombre;
}
