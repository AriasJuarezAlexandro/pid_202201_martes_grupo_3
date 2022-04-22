package com.proyecto.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Propietario;
import com.proyecto.service.PropietarioService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/propietario")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class PropietarioController {
	
	@Autowired
	private PropietarioService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Propietario>> listaPropietario(){
		List<Propietario> lista = service.listaPropietario();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarPropietario(@RequestBody Propietario obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdPro(0);
			Propietario objSalida = service.insertaActualizaPropietario(obj);
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
