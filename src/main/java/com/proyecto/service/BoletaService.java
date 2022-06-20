package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Boleta;

public interface BoletaService {
	public abstract List<Boleta> listarBoletas();
	// Registrar Boleta
	public abstract Boleta registrarBoleta(Boleta boleta);
	public abstract Boleta buscarBoletaPorPropietario(int idPropietario , int mes , int idServicio);
	//
}
