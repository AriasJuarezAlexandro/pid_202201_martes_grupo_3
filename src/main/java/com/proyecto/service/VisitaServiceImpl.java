package com.proyecto.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Visita;
import com.proyecto.repository.VisitaRepository;

@Service
public class VisitaServiceImpl implements VisitaService{

	@Autowired
	private VisitaRepository repository;
	
	@Override
	public List<Visita> listarVisitas() {
		return repository.findAll();
	}

	@Override
	public Visita registrarVisita(Visita visita) {
		return repository.save(visita);
	}

	@Override
	public List<Visita> listaVisitaFiltro(String dni, String nombre, int estado) {
		return repository.listaVisitaPorDniNombreEstado(dni, nombre, estado);
	}

	@Override
	public void registrarSalidaVisita(int idVisita, int estado , String comentario) {
		Visita temp = repository.findById(idVisita).get();
		temp.setFecha_salida(new Date());
		repository.registrarSalida(idVisita, estado , comentario);
	}

	@Override
	public List<Visita> buscarVisitasPorVisitante(int dniVisitante) {
		return repository.buscarVisitaPorVisitante(dniVisitante);
	}

}
