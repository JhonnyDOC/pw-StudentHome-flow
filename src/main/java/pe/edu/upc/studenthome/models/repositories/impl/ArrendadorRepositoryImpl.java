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
import pe.edu.upc.studenthome.models.repositories.ArrendadorRepository;

@Named
@ApplicationScoped
public class ArrendadorRepositoryImpl implements ArrendadorRepository, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "StudentHomePU")
	private EntityManager em;
	
	@Override
	public Arrendador save(Arrendador entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Arrendador update(Arrendador entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Optional<Arrendador> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
	}
	
	@Override
	public Optional<Arrendador> findById(Long id) throws Exception {
		Optional<Arrendador> optional = Optional.empty();
		String qlString = "Select a From Arrendador a Where a.id = ?1";
		TypedQuery<Arrendador> query = em.createQuery(qlString, Arrendador.class);
		query.setParameter(1, id);
		Arrendador arrendador = query.getResultList().stream().findFirst().orElse(null);
		if(arrendador != null) {
			optional = Optional.of(arrendador);
		}
		return optional;
	}

	@Override
	public List<Arrendador> findAll() throws Exception {
		List<Arrendador> arrendadores = new ArrayList<>();
		String qlString = "Select a From Arrendador a join Persona p on a.id=p.id";
		TypedQuery<Arrendador> query = em.createQuery(qlString, Arrendador.class);
		arrendadores = query.getResultList();
		return arrendadores;
	}

	@Override
	public List<Arrendador> findByNombre(String nombrePersona) throws Exception {
		List<Arrendador> arrendadores = new ArrayList<>();
		String qlString = "Select a from Arrendador a where a.persona.nombrePersona Like ?1";
		TypedQuery<Arrendador> query = em.createQuery(qlString, Arrendador.class);
		query.setParameter(1,"%" + nombrePersona.toUpperCase() + "%");
		arrendadores = query.getResultList();
		return arrendadores;
	}

	@Override
	public List<Arrendador> findByApellido(String apellidoPersona) throws Exception {
		List<Arrendador> arrendadores = new ArrayList<>();
		String qlString = "Select a from Arrendador a where a.persona.apellidoPersona Like ?1";
		TypedQuery<Arrendador> query = em.createQuery(qlString, Arrendador.class);
		query.setParameter(1, "%" + apellidoPersona.toUpperCase() + "%");
		arrendadores = query.getResultList();
		return arrendadores;
	}

	@Override
	public Optional<Arrendador> findBydni(String dni) throws Exception {
		Optional<Arrendador> optional = Optional.empty();
		String qlString = "Select a From Arrendador a where a.persona.dni = ?1";
		TypedQuery<Arrendador> query = em.createQuery(qlString, Arrendador.class);
		query.setParameter(1, dni);
		Arrendador arrendador = query.getResultList().stream().findFirst().orElse(null);
		if(arrendador != null) {
			optional = Optional.of(arrendador);
		}
		return optional;
	}
	
}
