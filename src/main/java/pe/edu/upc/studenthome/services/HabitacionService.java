package pe.edu.upc.studenthome.services;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Habitacion;

public interface HabitacionService extends CrudService<Habitacion, Integer>{
	List<Habitacion> findByNombreDistrito(String nombreDistrito) throws Exception;
	List<Habitacion> findByNombreArrendador(String nombreArrendador) throws Exception;
}
