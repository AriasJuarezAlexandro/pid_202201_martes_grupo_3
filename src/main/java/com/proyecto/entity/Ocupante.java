package com.proyecto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_OCUPANTES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ocupante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOcu;
	private String nomOcu;
	private String apeOcu;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fecnacOcu;
	private String dniOcu;
	private String teleOcu;
	@ManyToOne
	@JoinColumn(name = "idPro")
	private Propietario propietario;
}
