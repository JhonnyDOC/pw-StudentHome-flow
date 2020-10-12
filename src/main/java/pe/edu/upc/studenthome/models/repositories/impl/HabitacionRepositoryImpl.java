package pe.edu.upc.studenthome.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.studenthome.models.entities.Habitacion;
import pe.edu.upc.studenthome.models.repositories.HabitacionRepository;

public class HabitacionRepositoryImpl implements HabitacionRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "StudentHomePU")
	private EntityManager em;

	@Override
	public Habitacion save(Habitacion entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Habitacion update(Habitacion entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Habitacion> optional = findById(id);
		if( optional.isPresent() ) {
			em.remove( optional.get() );
		}	
	}

	@Override
	public Optional<Habitacion> findById(Integer id) throws Exception {
		Optional<Habitacion> optional = Optional.empty();		
		
		String qlString = "SELECT h FROM Habitacion h WHERE h.id = ?1";
		TypedQuery<Habitacion> query = em.createQuery(qlString, Habitacion.class);
		query.setParameter(1, id);
		
		Habitacion habitacion = query.getSingleResult();
		if(habitacion != null) {
			optional = Optional.of(habitacion);
		}		
		return optional;
	}

	@Override
	public List<Habitacion> findAll() throws Exception {
		List<Habitacion> habitaciones = new ArrayList<>();
		
		String qlString = "SELECT h FROM Habitacion h";
		TypedQuery<Habitacion> query = em.createQuery(qlString, Habitacion.class);

		habitaciones = query.getResultList();
		return habitaciones;
	}

	@Override
	public List<Habitacion> findByNombreDistrito(String nombreDistrito) throws Exception {
		List<Habitacion> habitaciones = new ArrayList<>();
		String qlString = "Select h From Habitacion h join Distrito d on h.distrito = d.id WHERE d.nombreDistrito LIKE '%?1%'";
		TypedQuery<Habitacion> query = em.createQuery(qlString, Habitacion.class);
		query.setParameter(1, nombreDistrito);
		habitaciones = query.getResultList();
		return habitaciones;
	}

	@Override
	public List<Habitacion> findByNombreArrendador(String nombreArrendador) throws Exception {
		List<Habitacion> habitaciones = new ArrayList<>();
		String qlString = "Select h From Habitacion h join Arrendador a on h.distrito = a.persona join Persona p on a.persona = p.id WHERE p.nombrePersona LIKE '%?1%'";
		TypedQuery<Habitacion> query = em.createQuery(qlString, Habitacion.class);
		query.setParameter(1, nombreArrendador);
		habitaciones = query.getResultList();
		return habitaciones;
	}

}
