package com.proyecto.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Departamento;
import com.proyecto.service.DepartamentoService;
import com.proyecto.util.AppSettings;


@RestController
@RequestMapping("/rest/departamento")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> registrarDepartamento(@RequestBody Departamento obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Departamento objSalida = departamentoService.registrarDepartamento(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error al registrar");
			}else {
				salida.put("mensaje", "Registro exitoso");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al registrar");
		}
		return ResponseEntity.ok(salida);
	}
}
