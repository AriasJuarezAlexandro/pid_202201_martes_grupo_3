package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Boleta;

public interface BoletaService {
	public abstract List<Boleta> listarBoletas();
	// Registrar Boleta
	public abstract Boleta registrarBoleta(Boleta boleta);
	public abstract Boleta buscarBoletaPorPropietario(int idPropietario , int mes , int idServicio);
	// Actualizar Boleta
	public abstract void pagarBoleta(int idBoleta , int estado);
	// Filtro
	public abstract List<Boleta> filtroBoleta(String dni, String nombre, int estado, int servicio);
	public abstract List<Boleta> filtroBoletaSinServicio(String dni, String nombre, int estado);
	public abstract List<Boleta> filtroBoletaSinEstado(String dni, String nombre,int servicio);
	public abstract List<Boleta> filtroBoletaSinEstadoSinServicio(String dni, String nombre);
}
