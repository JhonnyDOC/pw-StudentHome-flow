package pe.edu.upc.studenthome.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.studenthome.models.entities.Ciudad;
import pe.edu.upc.studenthome.models.repositories.CiudadRepository;

@Named
public class CiudadRepositoryImpl implements CiudadRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "StudentHomePU")
	private EntityManager em;
	
	@Override
	public Ciudad save(Ciudad entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Ciudad update(Ciudad entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Ciudad> optional = findById(id);
		if( optional.isPresent() ) {
			em.remove( optional.get() );
		}
	}

	@Override
	public Optional<Ciudad> findById(Integer id) throws Exception {
		Optional<Ciudad> optional = Optional.empty();		
		
		String qlString = "Select c From Ciudad c Where c.id = ?1";
		TypedQuery<Ciudad> query = em.createQuery(qlString, Ciudad.class);
		query.setParameter(1, id);
		
		Ciudad ciudad = query.getSingleResult();
		if(ciudad != null) {
			optional = Optional.of(ciudad);
		}		
		return optional;
	}

	@Override
	public List<Ciudad> findAll() throws Exception {
		List<Ciudad> ciudades = new ArrayList<>();
		
		String qlString = "Select c From Ciudad c";
		TypedQuery<Ciudad> query = em.createQuery(qlString, Ciudad.class);

		ciudades = query.getResultList();
		return ciudades;
	}

	@Override
	public List<Ciudad> findByNombre(String nombreCiudad) throws Exception {
		List<Ciudad> ciudades = new ArrayList<>();
		String qlString = "Select c From Ciudad c Where c.nombreCiudad Like '%?1%'";
		TypedQuery<Ciudad> query = em.createQuery(qlString, Ciudad.class);
		query.setParameter(1, nombreCiudad);
		ciudades = query.getResultList();
		return ciudades;
	}
	
}
