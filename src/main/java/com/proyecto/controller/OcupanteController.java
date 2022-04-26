package com.proyecto.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Mascota;
import com.proyecto.entity.Ocupante;
import com.proyecto.service.MascotaService;
import com.proyecto.service.OcupanteService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/ocupante")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class OcupanteController {

	@Autowired
	private OcupanteService ocupanteService;
	
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarOcupante(@RequestBody Ocupante obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdOcu(0);
			Ocupante objSalida = ocupanteService.insertaActualizaOcupantes(obj);
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
