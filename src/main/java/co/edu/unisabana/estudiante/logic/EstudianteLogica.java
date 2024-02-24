package co.edu.unisabana.estudiante.logic;

import co.edu.unisabana.estudiante.controller.DTO.EstudianteDTO;
import co.edu.unisabana.estudiante.model.EstudianteModelo;
import co.edu.unisabana.estudiante.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteLogica {

    private final EstudianteRepository estudianteRepository;

    public EstudianteLogica(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }


    public List<EstudianteDTO> buscarEstudianteDTO(int id) {
        return estudianteRepository.findById(id).stream().map(EstudianteModelo ->
                        new EstudianteDTO(EstudianteModelo.getId(), EstudianteModelo.getNombre(), EstudianteModelo.getEmail()))
                .collect(Collectors.toList());
    }


    public void guardarEstudiante(EstudianteDTO estudianteDTO) {
        if (estudianteRepository.findById(estudianteDTO.getId()).isEmpty()) {
            EstudianteModelo estudiante = new EstudianteModelo();
            estudiante.setId(estudianteDTO.getId());
            estudiante.setNombre(estudianteDTO.getNombre());
            estudiante.setEmail(estudianteDTO.getEmail());
            estudianteRepository.save(estudiante);
        } else throw new IllegalArgumentException("Ya se encuentra registrado el estudiante");
    }

}
