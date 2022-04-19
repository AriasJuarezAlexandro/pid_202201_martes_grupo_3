package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Mascota;

public interface MascotaService {
	public List<Mascota> listaMascota();
	public Mascota insertaActualizaMascota(Mascota obj);
}
