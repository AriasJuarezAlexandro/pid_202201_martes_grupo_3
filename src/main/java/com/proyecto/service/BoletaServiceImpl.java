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
	public void pagarBoleta(int idBoleta , int estado) {
		repository.pagoBoleta(idBoleta, estado);
	}
	
	@Override
	public Boleta buscarBoletaPorPropietario(int idPropietario , int mes , int idServicio) {
		return repository.buscarBoletasPorPropietario(idPropietario, mes , idServicio);
	}

	@Override
	public List<Boleta> filtroBoleta(String dni, String nombre, int estado, int servicio) {
		return repository.filtroBoleta(dni, nombre, estado, servicio);
	}

	@Override
	public List<Boleta> filtroBoletaSinServicio(String dni, String nombre, int estado) {
		return repository.filtroBoletaSinServicio(dni, nombre, estado);
	}

	@Override
	public List<Boleta> filtroBoletaSinEstado(String dni, String nombre, int servicio) {
		return repository.filtroBoletaSinEstado(dni, nombre, servicio);
	}

	@Override
	public List<Boleta> filtroBoletaSinEstadoSinServicio(String dni, String nombre) {
		return repository.filtroBoletaSinEstadoSinServicio(dni, nombre);
	}
}
