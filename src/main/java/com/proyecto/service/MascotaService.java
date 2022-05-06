package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Mascota;

public interface MascotaService {
	public abstract Mascota registrarMascota(Mascota mascota);
	public abstract List<Mascota> listarMascotas();
}
