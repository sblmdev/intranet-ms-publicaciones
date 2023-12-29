package com.sblm.intranetmspublicaciones.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.*;
import java.util.ArrayList;

@Entity
@Table(name = "publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
	private Long idGerencia;
    private TipoPublicacion tipoPublicacion;
    private String titulo;
    private String contenido;
    private LocalDate fechaPublicacion;
    private String urlImagen;
   
    
    
    public LocalDate getFechaEvento() {
		return fechaEvento;
	}
	public void setFechaEvento(LocalDate fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	private LocalDate fechaEvento;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdGerencia() {
		return idGerencia;
	}
	public void setIdGerencia(Long idGerencia) {
		this.idGerencia = idGerencia;
	}
	public TipoPublicacion getTipoPublicacion() {
		return tipoPublicacion;
	}
	public void setTipoPublicacion(TipoPublicacion tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	
    //private Gerencia gerenciaPublicacion;
 
    //private ArrayList<Gerencia> gerenciaVisualizacion;

}