package com.sblm.intranetmspublicaciones.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sblm.intranetmspublicaciones.entidades.Publicacion;
import com.sblm.intranetmspublicaciones.repositorios.PublicacionRepositorio;

import java.util.List;

@Service
public class PublicacionServicio {

    private final PublicacionRepositorio publicacionRepositorio;

    public PublicacionServicio(PublicacionRepositorio publicacionRepositorio) {
        this.publicacionRepositorio = publicacionRepositorio;
    }
   
    public List<Publicacion> GetAllPublicacion() {
        return publicacionRepositorio.findAll();
    }

    public Publicacion RegisterPublicacion(Publicacion publicacion) {
        return publicacionRepositorio.save(publicacion);
    }

    public Publicacion GetPublicacionById(Long id) {
        return publicacionRepositorio.findById(id).orElse(null);
    }

    public void DeletePublicacion(Long id) {
    	publicacionRepositorio.deleteById(id);
    }
    public List<Publicacion> GetAllPublicacionByTipoPublicacion(String tipoPublicacion) {
        return publicacionRepositorio.getAllByTipoPublicacion(tipoPublicacion);
    }

}
