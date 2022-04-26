package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Departamento;
import com.proyecto.entity.EdificioDepartamento;
import com.proyecto.entity.EstadoDepartamento;
import com.proyecto.entity.Mascota;
import com.proyecto.entity.Ocupante;
import com.proyecto.entity.Propietario;
import com.proyecto.entity.TipoDepartamento;
import com.proyecto.entity.Visitante;
import com.proyecto.service.DepartamentoService;
import com.proyecto.service.EdificioDepartamentoService;
import com.proyecto.service.EstadoDepartamentoService;
import com.proyecto.service.MascotaService;
import com.proyecto.service.OcupanteService;
import com.proyecto.service.PropietarioService;
import com.proyecto.service.TipoDepartamentoService;
import com.proyecto.service.VisitanteService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

	@Autowired
	private EdificioDepartamentoService edificioDepartamentoService;
	@Autowired
	private EstadoDepartamentoService estadoDepartamentoService;
	@Autowired
	private TipoDepartamentoService tipoDepartamentoService;
	@Autowired
	private DepartamentoService DepSer;

	@Autowired
	private PropietarioService propietarioService;
	@Autowired
	private MascotaService mascotaService;
	
	@Autowired
	private VisitanteService visitanteService;
	@Autowired
	private OcupanteService ocupanteService;
	
	@GetMapping("/listaOcupante")
	@ResponseBody
	public List<Ocupante> listaOcupante(){
		return ocupanteService.listaOcupantes();
	}
	
	@GetMapping("/listaPropietario")
	@ResponseBody
	public List<Propietario> listaPropietario(){
		return propietarioService.listaPropietario();
	}
	
	@GetMapping("/listaMascota")
	@ResponseBody
	public List<Mascota> listaMascota(){
		return mascotaService.listaMascota();
	}
	
	@GetMapping("/listaEdificioDepartamento")
	@ResponseBody
	public List<EdificioDepartamento> listaEdificioDepartamento(){
		return edificioDepartamentoService.listaEdificioDepartamento();
	}
	
	@GetMapping("/listaEstadoDepartamento")
	@ResponseBody
	public List<EstadoDepartamento> listaEstadoDepartamento(){
		return estadoDepartamentoService.listaEstadoDepartamento();
	}
	
	@GetMapping("/listaTipoDepartamento")
	@ResponseBody
	public List<TipoDepartamento> listaTipoDepartamento(){
		return tipoDepartamentoService.listaTipoDepartamento();
	}
	
	@GetMapping("/listaDepartamento")
	@ResponseBody
	public List<Departamento> listaDepartamento() {
		return DepSer.listaDepartamento();
	}

	@GetMapping("/listaVisitante")
	@ResponseBody
	public List<Visitante> listaVisitante(){
		return visitanteService.listaVisitante();
	}
}
