package pe.edu.upc.studenthome.models.repositories;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.studenthome.models.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	List<Persona> findByNombre(String nombrePersona) throws Exception;
	List<Persona> findByApellido(String apellidoPersona) throws Exception;
	Optional<Persona> findBydni(String dni) throws Exception;

}
