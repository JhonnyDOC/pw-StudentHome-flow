package pe.edu.upc.studenthome.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.studenthome.models.entities.Arrendador;

public interface ArrendadorServices extends CrudService<Arrendador, Long> {
	List<Arrendador> findByNombre(String nombrePersona) throws Exception;
	List<Arrendador> findByApellido(String apellidoPersona) throws Exception;
	Optional<Arrendador> findBydni(String dni) throws Exception;
}
