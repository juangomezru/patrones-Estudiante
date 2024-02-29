package co.edu.unisabana.estudiante.controller;

import co.edu.unisabana.estudiante.controller.DTO.EstudianteDTO;
import co.edu.unisabana.estudiante.logic.EstudianteLogica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudianteController {
    @Autowired
    EstudianteLogica estudianteLogica;

    private String variable;


    public EstudianteController(EstudianteLogica estudianteLogica) {
        this.estudianteLogica = estudianteLogica;
    }

    @GetMapping(path = "/estudiante/{id}")
    public List<EstudianteDTO> buscarEstudiante(@PathVariable int id) {
        return estudianteLogica.buscarEstudianteDTO(id);
    }

    @PostMapping (path = "/estudiante/agregar")
    public String guardarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        try {
            estudianteLogica.guardarEstudiante(estudianteDTO);
            return "Cliente agregado correctamente";
        } catch (IllegalArgumentException e) {
            return "El cliente no se pudo agregar " + e.getMessage();
        }

    }

    @GetMapping(path = "/pruebahola/{cantidad}")
    public String pruebahola(@PathVariable int cantidad) {
       for (int i = 0; i < cantidad; i++){
           int x = 0;
           System.out.println("Hola mundo");
           x++;
       }
       return variable;
    }
}
