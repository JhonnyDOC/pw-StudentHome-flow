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

import pe.edu.upc.studenthome.models.entities.Estudiante;
import pe.edu.upc.studenthome.models.repositories.EstudianteRepository;

@Named
@ApplicationScoped
public class EstudianteRepositoryImpl implements EstudianteRepository, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "StudentHomePU")
	private EntityManager em;
	
	@Override
	public Estudiante save(Estudiante entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Estudiante update(Estudiante entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Optional<Estudiante> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
	}
	
	@Override
	public Optional<Estudiante> findById(Long id) throws Exception {
		Optional<Estudiante> optional = Optional.empty();
		String qlString = "Select a From Estudiante a Where a.id = ?1";
		TypedQuery<Estudiante> query = em.createQuery(qlString, Estudiante.class);
		query.setParameter(1, id);
		Estudiante estudiante = query.getResultList().stream().findFirst().orElse(null);
		if(estudiante != null) {
			optional = Optional.of(estudiante);
		}
		return optional;
	}

	@Override
	public List<Estudiante> findAll() throws Exception {
		List<Estudiante> estudiantes = new ArrayList<>();
		String qlString = "Select e From Estudiante e join Persona p on e.id=p.id";
		TypedQuery<Estudiante> query = em.createQuery(qlString, Estudiante.class);
		estudiantes = query.getResultList();
		return estudiantes;
	}

	@Override
	public List<Estudiante> findByNombre(String nombrePersona) throws Exception {
		List<Estudiante> estudiantes = new ArrayList<>();
		String qlString = "Select e from Estudiante e where e.persona.nombrePersona Like ?1";
		TypedQuery<Estudiante> query = em.createQuery(qlString, Estudiante.class);
		query.setParameter(1,"%" + nombrePersona.toUpperCase() + "%");
		estudiantes = query.getResultList();
		return estudiantes;
	}

	@Override
	public List<Estudiante> findByApellido(String apellidoPersona) throws Exception {
		List<Estudiante> estudiantes = new ArrayList<>();
		String qlString = "Select e from Estudiante e where e.persona.apellidoPersona Like ?1";
		TypedQuery<Estudiante> query = em.createQuery(qlString, Estudiante.class);
		query.setParameter(1, "%" + apellidoPersona.toUpperCase() + "%");
		estudiantes = query.getResultList();
		return estudiantes;
	}

	@Override
	public Optional<Estudiante> findBydni(String dni) throws Exception {
		Optional<Estudiante> optional = Optional.empty();
		String qlString = "Select e From Estudiante e where e.persona.dni = ?1";
		TypedQuery<Estudiante> query = em.createQuery(qlString, Estudiante.class);
		query.setParameter(1, dni);
		Estudiante estudiante = query.getResultList().stream().findFirst().orElse(null);
		if(estudiante != null) {
			optional = Optional.of(estudiante);
		}
		return optional;
	}
	
}