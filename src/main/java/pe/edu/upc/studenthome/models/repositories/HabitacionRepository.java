package pe.edu.upc.studenthome.models.repositories;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
	List<Habitacion> findByNombreDistrito(String nombreDistrito) throws Exception;
	List<Habitacion> findByNombreArrendador(String nombreArrendador) throws Exception;
}
