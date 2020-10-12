package pe.edu.upc.studenthome.models.repositories;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{
	List<Ciudad> findByNombre(String nombreCiudad) throws Exception;
}
