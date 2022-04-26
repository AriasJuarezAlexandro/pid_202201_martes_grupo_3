package com.proyecto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto.entity.Visitante;
import com.proyecto.service.VisitanteService;
import com.proyecto.util.AppSettings;


@RestController
@RequestMapping("/url/visitante") 
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class VisitanteController {

	@Autowired
	private VisitanteService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Visitante>> listaVisitantes(){
		List<Visitante> lista = service.listaVisitante();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<HashMap<String, Object>> registrarVisitante(@RequestBody Visitante obj){
		HashMap<String, Object> salida = new HashMap<>();
		try {
			obj.setIdVisitante(0);
			Visitante objSalida = service.insertaActualizaVisitante(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			}else {
				salida.put("mensaje", "Se registró correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	
}
