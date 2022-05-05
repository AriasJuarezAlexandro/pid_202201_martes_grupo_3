package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.entity.TipoDepartamento;

public interface TipoDepartamentoService {
	public abstract List<TipoDepartamento> listaTipoDepartamento();
	public abstract Optional<TipoDepartamento> buscarTipoDepartamento(int id);
}
