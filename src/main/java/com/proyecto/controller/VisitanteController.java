package com.proyecto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Administrador;
import com.proyecto.entity.Visitante;
import com.proyecto.service.PropietarioService;
import com.proyecto.service.VisitanteService;
import com.proyecto.util.AppSettings;

@Controller
@RequestMapping(value = AppSettings.URL_ADMINISTRADOR)
public class VisitanteController {

	@Autowired
	private VisitanteService visitanteService;
	@Autowired
	private PropietarioService propietarioService;
	
	@RequestMapping(value = "/visitante")
	public String ocupantePage(@ModelAttribute("visitante")Visitante visitante , Model model) {
		try {
			model.addAttribute("visitantes" , visitanteService.listarVisitantes());
			model.addAttribute("propietarios" , propietarioService.listarPropietarios());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "visitante";
	}
	
	@PostMapping(value = "/registrarVisitante")
	public String registrarVisitante(@ModelAttribute("visitante")Visitante visitante , RedirectAttributes redirect , HttpSession session) {
	
		try {
			Administrador admin = (Administrador) session.getAttribute("user");
			visitante.setAdministrador(admin);
			visitanteService.registrarVisitante(visitante);
		} catch (Exception e) {
			redirect.addFlashAttribute("error","Error al registrar visitante");
			e.printStackTrace();
			return "redirect:/administrador/visitante";
		}
		redirect.addFlashAttribute("mensaje","Visitante registrado correctamente");
		return "redirect:/administrador/visitante";
	}
}
