package com.proyecto.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Administrador;
import com.proyecto.entity.Boleta;
import com.proyecto.entity.Propietario;
import com.proyecto.entity.Servicio;
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
	
	@PostMapping("/registrarBoleta")
	public String registraBoleta(RedirectAttributes redirect, HttpSession session,
			@RequestParam("fecha_pago") String fecha_pago,
			@RequestParam("id_servicio") int id_servicio, @RequestParam("id_propietario") int idPropietario) {

		try {

			Date fecha_vencimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_pago);
			
			Boleta temp = boletaService.buscarBoletaPorPropietario(idPropietario, fecha_vencimiento.getMonth() , id_servicio);
			if(temp == null) {
				Servicio servicio = servicioRepository.findById(id_servicio).get();
				Propietario propietario = propietarioService.buscarPorId(idPropietario).get();
				Administrador admin = (Administrador) session.getAttribute("user");

				Boleta obj = new Boleta();
				obj.setServicio(servicio);
				obj.setPropietario(propietario);
				obj.setAdministrador(admin);
				obj.setMes(fecha_vencimiento.getMonth());
				obj.setFechaEmision(new Date());
				obj.setFechaVencimiento(fecha_vencimiento);
				obj.setEstado(0);

				boletaService.registrarBoleta(obj);
				redirect.addFlashAttribute("mensaje", "Boleta registrada correctamente.");
			}else {
				redirect.addFlashAttribute("error", "Boleta del propietario ya registrada con el mismo servicio y en el mismo mes");
			}
			
		} catch (Exception e) {
			redirect.addFlashAttribute("error", "Error al registrar boleta");
			e.printStackTrace();
			return "redirect:/administrador/boleta";
		}

		return "redirect:/administrador/boleta";
	}
	
	@GetMapping(value = "/filtroBoleta")
	@ResponseBody
	public List<Boleta> filtroBoleta(@RequestParam(value = "dni", required = false, defaultValue = "") String dni,
			@RequestParam(value = "nombre", required = false, defaultValue = "") String nombre,
			@RequestParam(value = "estado", required = false, defaultValue = "0") int estado,
			@RequestParam(value = "servicio", required = false) int servicio) {

		System.out.println("SERVICIO : " + servicio);
		
		List<Boleta> temp = null;

		if (estado == -1 && servicio == -1) {
			temp = boletaService.filtroBoletaSinEstadoSinServicio("%" + dni + "%", "%" + nombre + "%");
		}else if(estado == -1) {
			temp = boletaService.filtroBoletaSinEstado("%" + dni + "%", "%" + nombre + "%", servicio);
		}else if(servicio == -1) {
			temp = boletaService.filtroBoletaSinServicio("%" + dni + "%", "%" + nombre + "%", estado);
		}else temp = boletaService.filtroBoleta("%" + dni + "%", "%" + nombre + "%",estado , servicio);

		return temp;
	}
	
}
