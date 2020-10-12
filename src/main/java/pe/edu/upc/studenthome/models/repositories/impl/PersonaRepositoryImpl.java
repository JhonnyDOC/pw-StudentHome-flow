package pe.edu.upc.studenthome.models.repositories.impl;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.studenthome.models.entities.Arrendador;
import pe.edu.upc.studenthome.models.entities.Persona;
import pe.edu.upc.studenthome.models.repositories.PersonaRepository;


@Named
@ApplicationScoped
public class PersonaRepositoryImpl implements PersonaRepository, Serializable {
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "StudentHomePU")
	private EntityManager em;

	@Override
	public Persona save(Persona entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Persona update(Persona entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Optional<Persona> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<Persona> findById(Long id) throws Exception {
		Optional<Persona> optional = Optional.empty();
		String qlString = "Select p From Persona p Where p.id = ?1";
		TypedQuery<Persona> query = em.createQuery(qlString, Persona.class);
		query.setParameter(1, id);
		Persona persona = query.getSingleResult();
		if(persona != null) {
			optional = Optional.of(persona);
		}
		return optional;
	}

	@Override
	public List<Persona> findAll() throws Exception {
		List<Persona> arrendadores = new ArrayList<>();
		String qlString = "Select p From Persona";
		TypedQuery<Persona> query = em.createQuery(qlString, Persona.class);
		arrendadores = query.getResultList();
		return arrendadores;
	}

	@Override
	public List<Persona> findByNombre(String nombrePersona) throws Exception {
		List<Persona> arrendadores = new ArrayList<>();
		String qlString = "Select p from Persona p where p.nombrePersona Like ?1";
		TypedQuery<Persona> query = em.createQuery(qlString, Persona.class);
		query.setParameter(1,"%" + nombrePersona.toUpperCase() + "%");
		arrendadores = query.getResultList();
		return arrendadores;
	}

	@Override
	public List<Persona> findByApellido(String apellidoPersona) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Persona> findBydni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
