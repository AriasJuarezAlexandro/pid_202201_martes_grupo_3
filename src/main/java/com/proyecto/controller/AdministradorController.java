package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.entity.Administrador;
import com.proyecto.service.AdministradorService;

@Controller
public class AdministradorController {
	
	@Autowired
	private AdministradorService administradorService;
	
	
	//@Autowired
	//private BCryptPasswordEncoder byBCryptPasswordEncoder;
	
	@GetMapping(value = {"/login" , "" , "/"} )
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/registro")
	public String mostrarFormularioDeRegistr(@ModelAttribute("administrador") Administrador obj) {
		System.out.println("Entra a pagina");
		return "registro";
	}
	
	@PostMapping("/registrarAdministrador")
	public String registroAdministrador(@ModelAttribute("administrador") Administrador obj) {
		System.out.println("Registra");
		administradorService.registrarAdministrador(obj);
		return "redirect:/registro?exito";
	}
	
}
