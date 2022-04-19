package com.proyecto.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tb_departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDep;
	private String metDep;
	private String telDep;
	private Date feini_dep;
	private Date fefin_dep;
	
	@ManyToOne
	@JoinColumn(name = "idEdificio")
	private EdificioDepartamento edificioDepartamento;
	@ManyToOne
	@JoinColumn(name = "idEst")
	private EstadoDepartamento estadoDepartamento;
	@ManyToOne
	@JoinColumn(name = "cod_tip")
	private TipoDepartamento tipoDepartamento;

}

