package com.proyecto.controller;

import java.util.HashMap;

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
@RequestMapping("/url/departamento") 
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> registrarDepartamento(@RequestBody Departamento obj){
		HashMap<String, Object> salida = new HashMap<>();
		try {
			obj.setIdDep(0);
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
