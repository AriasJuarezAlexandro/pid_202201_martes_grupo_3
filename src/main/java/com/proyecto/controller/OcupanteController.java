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
import com.proyecto.entity.Ocupante;
import com.proyecto.service.OcupanteService;
import com.proyecto.service.PropietarioService;
import com.proyecto.util.AppSettings;

@Controller
@RequestMapping(value = AppSettings.URL_ADMINISTRADOR)
public class OcupanteController {

	@Autowired
	private OcupanteService ocupanteService;
	@Autowired
	private PropietarioService propietarioService;
	
	@RequestMapping(value = "/ocupante")
	public String ocupantePage(@ModelAttribute("ocupante")Ocupante ocupante , Model model) {
		try {
			model.addAttribute("ocupantes" , ocupanteService.listarOcupantes());
			model.addAttribute("propietarios" , propietarioService.listarPropietarios());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ocupante";
	}
	
	@PostMapping(value = "/registrarOcupante")
	public String registrarOcupante(@ModelAttribute("ocupante")Ocupante ocupante , RedirectAttributes redirect , HttpSession session) {
	
		try {
			Ocupante temp = ocupanteService.buscarPorDni(ocupante.getDni());
			if(temp == null) {
				Administrador admin = (Administrador) session.getAttribute("user");
				ocupante.setAdministrador(admin);
				ocupanteService.registrarOcupante(ocupante);
				redirect.addFlashAttribute("mensaje","Ocupante registrado correctamente");
			}else {
				redirect.addFlashAttribute("error","Este ocupante ya se encuentra registrado");
			}
			
		} catch (Exception e) {
			redirect.addFlashAttribute("error","Error al registrar ocupante");
			e.printStackTrace();
			return "redirect:/administrador/ocupante";
		}
		
		return "redirect:/administrador/ocupante";
	}
}
