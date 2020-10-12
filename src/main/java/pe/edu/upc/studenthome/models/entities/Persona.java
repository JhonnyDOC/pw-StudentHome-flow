package pe.edu.upc.studenthome.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_persona", length = 20, nullable = false)
	private String nombrePersona;
	
	@Column(name = "apellido_persona", length = 30, nullable = false)
	private String apellidoPersona;
	
	@Column(name = "numero_telefono", length = 20, nullable = false)
	private String numeroTelefono;
	
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@Column(name = "direccion", length = 50, nullable = false)
	private String direccion;
	
	@OneToOne(mappedBy = "persona")
	private Arrendador arrendadores;
	
	@OneToOne(mappedBy = "persona")
	private Estudiante estudiantes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getApellidoPersona() {
		return apellidoPersona;
	}

	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Arrendador getArrendadores() {
		return arrendadores;
	}

	public void setArrendadores(Arrendador arrendadores) {
		this.arrendadores = arrendadores;
	}

	public Estudiante getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Estudiante estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
}
