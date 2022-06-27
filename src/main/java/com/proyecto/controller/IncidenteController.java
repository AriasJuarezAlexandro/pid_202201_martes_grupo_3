package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.repository.DepartamentoRepository;
import com.proyecto.repository.IncidenteRepository;
import com.proyecto.repository.TipoIncidenteRepository;
import com.proyecto.service.IncidenteService;
import com.proyecto.service.PropietarioService;
import com.proyecto.util.AppSettings;

@Controller
@RequestMapping(value = AppSettings.URL_ADMINISTRADOR)
public class IncidenteController {
	
	@Autowired
	DepartamentoRepository departamentoService;
	@Autowired
	TipoIncidenteRepository tipoIncidenteRepository;
	@Autowired
	IncidenteService incidenteService;
	@Autowired
	IncidenteRepository incidenteRepository;
	@Autowired
	PropietarioService propietarioService;
	
	
	
}
