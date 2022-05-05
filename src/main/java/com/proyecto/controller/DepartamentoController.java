package com.proyecto.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Administrador;
import com.proyecto.entity.Departamento;
import com.proyecto.entity.TipoDepartamento;
import com.proyecto.service.DepartamentoService;
import com.proyecto.service.EdificioService;
import com.proyecto.service.TipoDepartamentoService;
import com.proyecto.util.AppSettings;

@Controller
@RequestMapping(value = AppSettings.URL_ADMINISTRADOR)
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private EdificioService edificioService;
	@Autowired
	private TipoDepartamentoService tipodepaService;
	
	@RequestMapping(value = "/departamento")
	public String departamentoPage(@ModelAttribute("departamento") Departamento departamento ,
								    Model model) {
		try {
			
			
			model.addAttribute("edificios" , edificioService.listaEdificios());
			model.addAttribute("tipodepartamentos" , tipodepaService.listaTipoDepartamento());
			model.addAttribute("departamentos" , departamentoService.listaDepartamento());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "departamento";
	}
	
	@PostMapping(value = "/registrarDepartamento")
	public String registrarDepartamento(@Valid @ModelAttribute("departamento") Departamento departamento , BindingResult result , 
										RedirectAttributes redirect , HttpSession session) {
		try {
			
			if (result.hasErrors()) {
				redirect.addFlashAttribute("error","Complete todos los campos correctamente.");
				return "administrador/departamento";
			}
			
			Optional<TipoDepartamento> temp = tipodepaService.buscarTipoDepartamento(1);
			Administrador admin = (Administrador) session.getAttribute("user");
			departamento.setAdministrador(admin);
			departamento.setTipoDepartamento(temp.get());
			departamento.setFecha_registro(new Date());
			departamento.setEstado(1);
			departamentoService.registrarDepartamento(departamento);
		} catch (Exception e) {
			redirect.addFlashAttribute("error","Error al registrar departamento");
			e.printStackTrace();
			return "redirect:/administrador/departamento";
		}
		redirect.addFlashAttribute("mensaje","El Departamento fue registrado correctamente");
		return "redirect:/administrador/departamento";
	}
	
	@PutMapping(value = "/actualizarEstado")
	public String actualizarEstadoDepartamento(int id , int estado ,  RedirectAttributes redirect) {
		try {
			departamentoService.cambiarEstado(id, estado);
			
		} catch (Exception e) {
			redirect.addFlashAttribute("error","Error al actualizar el estado departamento");
			e.printStackTrace();
			return "redirect:/administrador/departamento";
		}
		redirect.addFlashAttribute("mensaje","El estado del departamento fue cambiado correctamente");
		return "redirect:/administrador/departamento";
	}
}
