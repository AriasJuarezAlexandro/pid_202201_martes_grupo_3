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
import com.proyecto.entity.Edificio;
import com.proyecto.service.DistritoEdificioService;
import com.proyecto.service.EdificioService;
import com.proyecto.util.AppSettings;

@Controller
@RequestMapping(value = AppSettings.URL_ADMINISTRADOR)
public class EdificioController {
	
	@Autowired
	private EdificioService edificioService;
	@Autowired
	private DistritoEdificioService distritoedificioService;
	
	@RequestMapping(value = "/edificio")
	public String edificioPage(@ModelAttribute("edificio") Edificio edificio , Model model) {
		try {
			model.addAttribute("edificios" , edificioService.listaEdificios());
			model.addAttribute("distritos" , distritoedificioService.listaDistritos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "edificio";
	}
	
	@PostMapping(value = "/registrarEdificio")
	public String registrarEdificio(@ModelAttribute("edificio") Edificio edificio , RedirectAttributes redirect , HttpSession session) {
		try {		
			Administrador admin = (Administrador) session.getAttribute("user");
			edificio.setAdministrador(admin);
			edificioService.registrarEdificio(edificio);			
		} catch (Exception e) {
			redirect.addFlashAttribute("error","Error al registrar el edificio");
			e.printStackTrace();
			return "redirect:/administrador/edificio";
		}
		redirect.addFlashAttribute("mensaje","Edificio registrado correctamente");
		return "redirect:/administrador/edificio";
	}
}
