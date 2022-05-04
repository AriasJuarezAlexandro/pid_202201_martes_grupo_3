package com.proyecto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_distrito_edi")
public class DistritoEdificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_dis; 
    private String nom_dis;
}
