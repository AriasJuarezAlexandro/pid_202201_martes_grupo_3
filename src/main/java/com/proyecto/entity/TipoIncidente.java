package com.proyecto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_tipoincidente")
public class TipoIncidente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idTipoIncidente;
	String descripcion;
}
