package co.edu.unisabana.estudiante.repository;

import co.edu.unisabana.estudiante.model.EstudianteModelo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EstudianteRepository extends JpaRepository<EstudianteModelo, Integer> {
}
