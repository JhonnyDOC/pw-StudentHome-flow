package pe.edu.upc.studenthome.services;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Distrito;

public interface DistritoService extends CrudService<Distrito, Integer> {
	List<Distrito> findByNombre(String nombreDistrito) throws Exception;
}
