package com.proyecto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Administrador;
import com.proyecto.entity.Propietario;
import com.proyecto.entity.Visita;
import com.proyecto.entity.Visitante;
import com.proyecto.service.PropietarioService;
import com.proyecto.service.VisitaService;
import com.proyecto.service.VisitanteService;
import com.proyecto.util.AppSettings;

@Controller
@RequestMapping(value = AppSettings.URL_ADMINISTRADOR)
public class VisitaController {

	@Autowired
	private VisitaService visitaService;
	@Autowired
	private VisitanteService visitanteService;
	@Autowired
	private PropietarioService propietarioService;
	
	@RequestMapping(value = "/visita")
	public String visitaPage(Model model) {
		try {
			model.addAttribute("propietarios" , propietarioService.listarPropietarios());
			model.addAttribute("visitas", visitaService.listarVisitas());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "visita";
	}
	
	@PostMapping(value = "/registraVisita")
	public String registraVisita(RedirectAttributes redirect , HttpSession session ,
			@RequestParam("dni") int dni ,
			@RequestParam(value = "fecha_cita") String fecha_cita ,
			@RequestParam("hora_ingreso") String hora_ingreso ,
			@RequestParam("hora_salida") String hora_salida ,
			@RequestParam("id_propietario") int idPropietario) {

		try {
			Date fecha_ingreso = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fecha_cita + ' ' + hora_ingreso + ":00");
			Date fecha_salida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fecha_cita + ' ' + hora_salida + ":00");
			
			Visitante visitante = visitanteService.buscarPorDni(dni);
			Optional<Propietario> propietario = propietarioService.buscarPorId(idPropietario);
			Administrador admin = (Administrador) session.getAttribute("user");
			
			Visita temp = new Visita();
			temp.setFecha_entrada(fecha_ingreso);
			temp.setFecha_salida(fecha_salida);
			temp.setFecha_registro(new Date());
			temp.setVisitante(visitante);
			temp.setPropietario(propietario.get());
			temp.setAdministrador(admin);
			temp.setEstado(0);
			visitaService.registrarVisita(temp);
		} catch (ParseException e) {
			redirect.addFlashAttribute("error","Error al registrar visita");
			e.printStackTrace();
			return "redirect:/administrador/visita";
		}
		redirect.addFlashAttribute("mensaje","Visita registrada correctamente.");
		return "redirect:/administrador/visita";
	}
	
}