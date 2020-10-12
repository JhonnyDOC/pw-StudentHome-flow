package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.studenthome.models.entities.Estudiante;
import pe.edu.upc.studenthome.models.repositories.EstudianteRepository;
import pe.edu.upc.studenthome.models.repositories.PersonaRepository;
import pe.edu.upc.studenthome.services.EstudianteService;

@Named
@ApplicationScoped
public class EstudianteServiceImpl implements EstudianteService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EstudianteRepository estudianteRepository;
	
	@Inject
	private PersonaRepository personaRepository;
	
	@Transactional
	@Override
	public Estudiante save(Estudiante entity) throws Exception {
		personaRepository.save(entity.getPersona());
		return estudianteRepository.save(entity);
	}
	
	@Transactional
	@Override
	public Estudiante update(Estudiante entity) throws Exception {
		personaRepository.update(entity.getPersona());
		return estudianteRepository.update(entity);
	}
	
	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		estudianteRepository.deleteById(id);
	}
	
	@Override
	public Optional<Estudiante> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return estudianteRepository.findById(id);
	}

	@Override
	public List<Estudiante> findAll() throws Exception {
		// TODO Auto-generated method stub
		return estudianteRepository.findAll();
	}

	@Override
	public List<Estudiante> findByNombre(String nombrePersona) throws Exception {
		// TODO Auto-generated method stub
		return estudianteRepository.findByNombre(nombrePersona);
	}

	@Override
	public List<Estudiante> findByApellido(String apellidoPersona) throws Exception {
		// TODO Auto-generated method stub
		return estudianteRepository.findByApellido(apellidoPersona);
	}

	@Override
	public Optional<Estudiante> findBydni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return estudianteRepository.findBydni(dni);
	}
	
}
