package com.proyecto.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Administrador;
import com.proyecto.entity.Propietario;
import com.proyecto.service.DepartamentoService;
import com.proyecto.service.PropietarioService;
import com.proyecto.util.AppSettings;

@Controller
@RequestMapping(value = AppSettings.URL_ADMINISTRADOR)
public class PropietarioController {

	@Autowired
	private PropietarioService propietarioService;
	@Autowired
	private DepartamentoService departamentoService;

	@RequestMapping(value = "/propietario")
	public String propietarioPage(@ModelAttribute("propietario") Propietario propietario, Model model) {
		try {
			model.addAttribute("propietarios", propietarioService.listarPropietarios());
			model.addAttribute("departamentos", departamentoService.listaDepartamento());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "propietario";
	}

	@PostMapping(value = "/registrarPropietario")
	public String registrarPropietario(@ModelAttribute("propietario") Propietario propietario,
			RedirectAttributes redirect, HttpSession session) {
		try {
			Propietario temp = propietarioService.buscarPorDni(propietario.getDni());
			if (temp == null) {
				Administrador admin = (Administrador) session.getAttribute("user");
				propietario.setAdministrador(admin);
				departamentoService.actualizarTipoDepa(propietario.getDepartamento().getIdDepartamento(), 2);
				propietario.setEstado(1);
				propietario.setFecha_registro(new Date());
				propietarioService.registrarPropietario(propietario);
				redirect.addFlashAttribute("mensaje", "Propietario registrado correctamente");
			}else {
				redirect.addFlashAttribute("error", "Este propietario ya se encuentra registrado");
			}

		} catch (Exception e) {
			redirect.addFlashAttribute("error", "Error al registrar propietario");
			e.printStackTrace();
			return "redirect:/administrador/propietario";
		}

		
		return "redirect:/administrador/propietario";
	}
}
