package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.studenthome.models.entities.Arrendador;
import pe.edu.upc.studenthome.models.repositories.ArrendadorRepository;
import pe.edu.upc.studenthome.models.repositories.PersonaRepository;
import pe.edu.upc.studenthome.services.ArrendadorServices;

@Named
@ApplicationScoped
public class ArrendadorServiceImpl implements ArrendadorServices, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ArrendadorRepository arrendadorRepository;
	
	@Inject
	private PersonaRepository personaRepository;

	@Transactional
	@Override
	public Arrendador save(Arrendador entity) throws Exception {
		personaRepository.save(entity.getPersona());
		return arrendadorRepository.save(entity);
	}
	
	@Transactional
	@Override
	public Arrendador update(Arrendador entity) throws Exception {
		personaRepository.update(entity.getPersona());
		return arrendadorRepository.update(entity);
	}
	
	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		arrendadorRepository.deleteById(id);
		
	}

	@Override
	public Optional<Arrendador> findById(Long id) throws Exception {
		return arrendadorRepository.findById(id);
	}

	@Override
	public List<Arrendador> findAll() throws Exception {
		return arrendadorRepository.findAll();
	}

	@Override
	public List<Arrendador> findByNombre(String nombrePersona) throws Exception {
		return arrendadorRepository.findByNombre(nombrePersona);
	}

	@Override
	public List<Arrendador> findByApellido(String apellidoPersona) throws Exception {
		return arrendadorRepository.findByApellido(apellidoPersona);
	}

	@Override
	public Optional<Arrendador> findBydni(String dni) throws Exception {
		return arrendadorRepository.findBydni(dni);
	}

}
