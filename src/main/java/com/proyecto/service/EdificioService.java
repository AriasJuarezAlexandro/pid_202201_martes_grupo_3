package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Edificio;

public interface EdificioService {
	public abstract Edificio registrarEdificio(Edificio edificio);
	public abstract List<Edificio> listaEdificios();
}
