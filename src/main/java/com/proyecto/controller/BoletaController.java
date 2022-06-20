package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.repository.ServicioRepository;
import com.proyecto.service.BoletaService;
import com.proyecto.service.DepartamentoService;
import com.proyecto.service.PropietarioService;
import com.proyecto.util.AppSettings;

@Controller
@RequestMapping(value = AppSettings.URL_ADMINISTRADOR)
public class BoletaController {
	@Autowired
	private BoletaService boletaService;
	@Autowired
	private PropietarioService propietarioService;
	@Autowired
	private ServicioRepository servicioRepository;
	@Autowired
	private DepartamentoService departamentoService;
	
	@RequestMapping("/boleta")
	public String boletaPage(Model model) {
		model.addAttribute("boletas", boletaService.listarBoletas());
		model.addAttribute("servicios", servicioRepository.findAll());
		model.addAttribute("propietarios", propietarioService.listarPropietarios());
		return "boleta";
	}
}
