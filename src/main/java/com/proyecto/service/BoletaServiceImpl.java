package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Boleta;
import com.proyecto.repository.BoletaRepository;

@Service
public class BoletaServiceImpl implements BoletaService{
	
	@Autowired
	private BoletaRepository repository;
	
	@Override
	public List<Boleta> listarBoletas() {
		return repository.findAll();
	}
	
	@Override
	public Boleta registrarBoleta(Boleta boleta) {
		return repository.save(boleta);
	}
	
	@Override
	public Boleta buscarBoletaPorPropietario(int idPropietario , int mes , int idServicio) {
		return repository.buscarBoletasPorPropietario(idPropietario, mes , idServicio);
	}
}
