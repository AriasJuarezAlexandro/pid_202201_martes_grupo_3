package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Propietario;
import java.util.List;

public interface PropietarioRepository extends JpaRepository<Propietario, Integer>{

}
