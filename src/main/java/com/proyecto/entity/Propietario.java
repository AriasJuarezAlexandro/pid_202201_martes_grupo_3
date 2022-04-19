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
@Table(name = "TB_PROPIETARIO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Propietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPro;
	private String nomPro;
	private String apePro;
	private String dniPro;
	private String telPro;
	private int idDep;
	/*@ManyToOne
	@JoinColumn(name = "idDep")
	private Departamento departamento;f
	*/
	
	
}
