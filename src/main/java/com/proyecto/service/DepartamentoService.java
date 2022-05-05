package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Departamento;

public interface DepartamentoService {
	public abstract Departamento registrarDepartamento(Departamento departamento);
	public abstract List<Departamento> listaDepartamento();
	public void cambiarEstado(int id , int estado);
	public abstract void actualizarTipoDepa(int id , int idTipo);
}
