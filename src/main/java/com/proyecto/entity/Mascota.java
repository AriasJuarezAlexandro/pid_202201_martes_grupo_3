package com.proyecto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_MASCOTA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMasc;
	private String nomMasc;
	private int idPro;
	/*
	 @ManyToOne
	@JoinColumn(name = "idPro")
	private Propietario propietario;

	 * */	
}
