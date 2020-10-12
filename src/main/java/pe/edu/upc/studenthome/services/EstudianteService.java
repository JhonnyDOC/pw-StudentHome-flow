package pe.edu.upc.studenthome.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.studenthome.models.entities.Estudiante;

public interface EstudianteService extends CrudService<Estudiante, Long>{
	List<Estudiante> findByNombre(String nombrePersona) throws Exception;
	List<Estudiante> findByApellido(String apellidoPersona) throws Exception;
	Optional<Estudiante> findBydni(String dni) throws Exception;
}
