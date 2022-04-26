package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Mascota;

public interface MascotaService {
	public abstract List<Mascota> listaMascota();
	public abstract Mascota insertaActualizaMascota(Mascota obj);
}
