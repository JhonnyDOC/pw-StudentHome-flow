package pe.edu.upc.studenthome.models.repositories;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.studenthome.models.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	List<Estudiante> findByNombre(String nombrePersona) throws Exception;
	List<Estudiante> findByApellido(String apellidoPersona) throws Exception;
	Optional<Estudiante> findBydni(String dni) throws Exception;
}
