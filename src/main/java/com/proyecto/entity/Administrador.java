package com.proyecto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_administrador")
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdmin;
	
	@Pattern(regexp = "[0-9]+" , message = "{Pattern.Administrador.dni}")
	private String dni;
	
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(min=4,max=60 , message = "Los nombres deben ser entre 4 y 60 caracteres")
	@Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]{4,60}" , message = "Solo letras")
	private String nombres;
	
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(min=4,max=60 , message = "Los apellidos deben ser entre 4 y 60 caracteres")
	@Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]{4,60}" , message = "Solo letras")
	private String apellidos;
	
	@Email(message = "Debe ser una direccion de correo electronico con el formato correcto")
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(min=5,max=30 , message = "El email debe ser entre 5 y 30 caracteres")
	private String email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_nacimiento;
	
	@OneToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
}
