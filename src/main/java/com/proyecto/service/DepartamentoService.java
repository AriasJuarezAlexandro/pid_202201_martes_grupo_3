package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Departamento;

public interface DepartamentoService {

	public abstract List<Departamento> listaDepartamento();
	public abstract Departamento registrarDepartamento(Departamento departamento);
}
