package com.proyecto.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Administrador;
import com.proyecto.entity.Departamento;
import com.proyecto.entity.Incidente;
import com.proyecto.entity.TipoIncidente;
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
	
	@RequestMapping("/incidente")
	public String incidentePage(Model model) {
		model.addAttribute("propietarios", propietarioService.listarPropietarios());
		model.addAttribute("tipoincidentes", tipoIncidenteRepository.findAll());
		model.addAttribute("incidentes", incidenteService.listaIncidentes());
		return "incidente";
	}
	
	@PostMapping(value = "/registrarIncidente")
	public String registraIncidente(RedirectAttributes redirect , HttpSession session ,
			@RequestParam("id_departamento") int idDepartamento ,
			@RequestParam("id_tipoIncidente") int idTipoDepartamento,
			@RequestParam(value = "comentario" , required = false , defaultValue = "") String comentario) {

		try {
			
			List<Incidente> busqueda = incidenteService.validacionIncidente(idDepartamento, idTipoDepartamento);
			
			if(busqueda.isEmpty()) {
				
				Administrador admin = (Administrador) session.getAttribute("user");
				Departamento depa = departamentoService.findById(idDepartamento).get();
				TipoIncidente tipoIncidente = tipoIncidenteRepository.findById(idTipoDepartamento).get();
				
				Incidente obj = new Incidente();
				obj.setDepartamento(depa);
				obj.setTipoIncidente(tipoIncidente);
				obj.setAdministrador(admin);
				obj.setFecha_registro(new Date());
				obj.setComentario(comentario);
				obj.setEstado(0);
				
				incidenteService.registrarIncidente(obj);
				redirect.addFlashAttribute("mensaje","Incidente registrado correctamente.");
			}else {
				redirect.addFlashAttribute("error","Incidente del departamento previamente registrado sigue sin atender.");
			}
			

		} catch (Exception e) {
			redirect.addFlashAttribute("error","Error al registrar incidente");
			e.printStackTrace();
			return "redirect:/administrador/incidente";
		}
		
		return "redirect:/administrador/incidente";
	}
	
	@PutMapping(value = "/atenderIncidente")
	public String atenderIncidente(
			@RequestParam(value = "idIncidente") int idIncidente ,
			@RequestParam(value = "estado") int estado , RedirectAttributes redirect) {
		System.out.println("LOG : " + estado);
		incidenteService.cambiarEstado(idIncidente, estado);
		
		return "redirect:/administrador/incidente";
	}
	
	@GetMapping(value = "/filtroIncidente")
	@ResponseBody
	public List<Incidente> filtroIncidente(
			@RequestParam(value = "departamento") int idDepa,
			@RequestParam(value = "tipo") int idTipo,
			@RequestParam(value = "estado") int estado) {
		
		System.out.println("INFO : " + idDepa + " | " + idTipo + " | " + estado);
		
		List<Incidente> temp = null;

		if(idTipo == -1 && estado == -1 && idDepa > 0) temp = incidenteRepository.filtroDepartamento(idDepa);
		else if(idDepa == -1 && estado == -1 && idTipo > 0) temp = incidenteRepository.filtroTipo(idTipo);
		else if(idDepa == -1 && idTipo == -1 && estado != -1) temp = incidenteRepository.filtroEstado(estado);
		else if(estado == -1 && idDepa > 0 && idTipo > 0) temp = incidenteRepository.filtroDepartamentoTipo(idDepa, idTipo);
		else if(idDepa == -1 && estado > -1 && idTipo > 0) temp = incidenteRepository.filtrTipoEstado(idTipo , estado);
		else if(idTipo == -1 && estado > -1 && idDepa > 0) temp = incidenteRepository.filtroDepartamentoEstado(idDepa, estado);
		else if(idDepa == -1 && idTipo == -1 && estado == -1) temp = incidenteService.listaIncidentes();
		else temp =  incidenteRepository.filtro(idDepa, idTipo, estado);
		
		return temp;
	}
	
}
