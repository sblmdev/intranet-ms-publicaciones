package com.sblm.intranetmspublicaciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sblm.intranetmspublicaciones.entidades.Publicacion;
import com.sblm.intranetmspublicaciones.servicios.PublicacionServicio;

import java.util.List;
import org.springframework.util.FileCopyUtils;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/publicaciones")
public class PublicacionControlador {

    private final PublicacionServicio publicacionServicio;

    @Autowired
    public PublicacionControlador(PublicacionServicio publicacionService) {
        this.publicacionServicio = publicacionService;
    }
    
    @GetMapping
    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return publicacionServicio.GetAllPublicacion();
    }

    @GetMapping("/{id}")
    public Publicacion obtenerPublicacionPorId(@PathVariable Long id) {
        return publicacionServicio.GetPublicacionById(id);
    }

    @PostMapping
    public Publicacion guardarPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionServicio.RegisterPublicacion(publicacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarPublicacion(@PathVariable Long id) {
    	publicacionServicio.DeletePublicacion(id);
    }
    
    
    @PostMapping("/guardarImagen/{tipoPublicacion}")
    public String guardarImagen(@RequestParam("archivo") MultipartFile archivo,@PathVariable String tipoPublicacion) {
        String directorioAlmacenamiento="/home/intranet_user/Documentos";
        
        switch (tipoPublicacion) {
        	case "Leyes":
        		directorioAlmacenamiento="/home/intranet_user/Documentos/Leyes";
        		break;
        	case "Resoluciones":
        		directorioAlmacenamiento="/home/intranet_user/Documentos/Resoluciones";
        		break;
        	case "Reglamento":
        		directorioAlmacenamiento="/home/intranet_user/Documentos/Reglamento";
        		break;
        	case "Directivas":
        		directorioAlmacenamiento="/home/intranet_user/Documentos/Directivas";
        		break;
        	case "Acuerdos":
        		directorioAlmacenamiento="/home/intranet_user/Documentos/Acuerdos";
        		break;
        	case "Manuales":
        		directorioAlmacenamiento="/home/intranet_user/Documentos/Manuales";
        		break;
        }
        
        Path directorioPath = Paths.get(directorioAlmacenamiento);
        if (!Files.exists(directorioPath)) {
            try {
                Files.createDirectories(directorioPath);
            } catch (IOException e) {
                return "Error al crear el directorio de almacenamiento";
            }
        }
        
        String nombreArchivo = archivo.getOriginalFilename();

        Path rutaCompleta = Paths.get(directorioAlmacenamiento, nombreArchivo);

        try {
            Files.write(rutaCompleta, archivo.getBytes());
            return rutaCompleta.toString();
        } catch (IOException e) {
            return "";
        }
    }
    
    @GetMapping("/{tipoPublicacion}")
    public List<Publicacion> obtenerTodasLasPublicacionesPorTipoPublicacion(@PathVariable String tipoPublicacion) {
        return publicacionServicio.GetAllPublicacionByTipoPublicacion(tipoPublicacion);
    }
}