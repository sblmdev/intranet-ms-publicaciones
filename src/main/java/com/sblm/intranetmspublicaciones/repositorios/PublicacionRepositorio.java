package com.sblm.intranetmspublicaciones.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sblm.intranetmspublicaciones.entidades.Publicacion;


public interface PublicacionRepositorio extends JpaRepository<Publicacion, Long> {
	  List<Publicacion> getAllByTipoPublicacion(String tipoPublicacion);
}
