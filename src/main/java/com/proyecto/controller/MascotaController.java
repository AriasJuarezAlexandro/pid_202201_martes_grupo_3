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
import com.proyecto.entity.Mascota;
import com.proyecto.service.MascotaService;
import com.proyecto.service.PropietarioService;
import com.proyecto.util.AppSettings;

@Controller
@RequestMapping(value = AppSettings.URL_ADMINISTRADOR)
public class MascotaController {

	@Autowired
	private PropietarioService propietarioService;
	@Autowired
	private MascotaService mascotaService;
	
	@RequestMapping(value = "/mascota")
	public String mascotaPage(@ModelAttribute("mascota") Mascota mascota , Model model) {
		try {
			model.addAttribute("mascotas" , mascotaService.listarMascotas());
			model.addAttribute("propietarios" , propietarioService.listarPropietarios());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mascota";
	}
	
	@PostMapping(value = "/registrarMascota")
	public String registrarMascota(@ModelAttribute("mascota") Mascota mascota , RedirectAttributes redirect , HttpSession session) {
		try {
			Administrador admin = (Administrador) session.getAttribute("user");
			mascota.setAdministrador(admin);
			mascotaService.registrarMascota(mascota);
		} catch (Exception e) {
			redirect.addFlashAttribute("error","Error al registrar mascota");
			e.printStackTrace();
			return "redirect:/administrador/mascota";
		}
		redirect.addFlashAttribute("mensaje","Mascota registrado correctamente");
		return "redirect:/administrador/mascota";
	}
}
