package pe.edu.upc.studenthome.models.repositories;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Distrito;

public interface DistritoRepository extends JpaRepository<Distrito, Integer>{
	List<Distrito> findByNombre(String nombreDistrito) throws Exception;
}
