package com.proyecto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.entity.Administrador;
import com.proyecto.service.AdministradorService;
import com.proyecto.util.AppSettings;

@Controller
@RequestMapping(value = AppSettings.URL_ADMINISTRADOR)
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;
	
	@RequestMapping(value = "/menu")
	public String menuPage(Authentication auth , HttpSession session) {
		System.out.println("Entrando a menu");
		String nomUsuario = auth.getName();
		System.out.println(nomUsuario);
		try {
			Administrador bean = administradorService.buscarAdministradorPorEmail(nomUsuario);
			session.setAttribute("user", bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "menu";
	}
}
