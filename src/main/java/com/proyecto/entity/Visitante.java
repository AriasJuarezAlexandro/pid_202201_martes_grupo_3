package com.proyecto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_VISITANTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visitante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVis;
	private String nomVis;
	private String apeVis;
	private String dniVis;
	private String telVis;
	private String dirVis;
	
	
	/*soon*/
	
}
