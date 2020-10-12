package pe.edu.upc.studenthome.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
	
	@Id
	private Long id;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private Persona persona;
	
	@Column(name = "descripcionUniv", length = 50, nullable = false)
	private String descripcionUniv;
	
	@Column(name = "roomate", nullable = false)
	private Boolean roomate;
	
	@Column(name = "usuarioEstudiante")
	private String usuarioEstudiante;
	
	@Column(name = "contraseñaEstudiante")
	private String contraseñaEstudiante;
	
	@OneToMany(mappedBy = "estudiante")
	private List<DetalleRenta> detalleRentas;
	
	@OneToMany(mappedBy = "estudiante")
	private List<Calificacion> calificaciones;
	
	@OneToMany(mappedBy = "estudianteUno")
	private List<CalificacionRoommate> calificacionesRoommatesUno;
	
	@OneToMany(mappedBy = "estudianteDos")
	private List<CalificacionRoommate> calificacionesRoommatesDos;
	
	public Estudiante () {
		detalleRentas = new ArrayList<DetalleRenta>();
		calificaciones = new ArrayList<Calificacion>();
		calificacionesRoommatesUno = new ArrayList<CalificacionRoommate>();
		calificacionesRoommatesDos = new ArrayList<CalificacionRoommate>();
		persona = new Persona();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getDescripcionUniv() {
		return descripcionUniv;
	}

	public void setDescripcionUniv(String descripcionUniv) {
		this.descripcionUniv = descripcionUniv;
	}

	public Boolean getRoomate() {
		return roomate;
	}

	public void setRoomate(Boolean roomate) {
		this.roomate = roomate;
	}

	public List<DetalleRenta> getDetalleRentas() {
		return detalleRentas;
	}

	public void setDetalleRentas(List<DetalleRenta> detalleRentas) {
		this.detalleRentas = detalleRentas;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public List<CalificacionRoommate> getCalificacionesRoommatesUno() {
		return calificacionesRoommatesUno;
	}

	public void setCalificacionesRoommatesUno(List<CalificacionRoommate> calificacionesRoommatesUno) {
		this.calificacionesRoommatesUno = calificacionesRoommatesUno;
	}

	public List<CalificacionRoommate> getCalificacionesRoommatesDos() {
		return calificacionesRoommatesDos;
	}

	public void setCalificacionesRoommatesDos(List<CalificacionRoommate> calificacionesRoommatesDos) {
		this.calificacionesRoommatesDos = calificacionesRoommatesDos;
	}

	public String getUsuarioEstudiante() {
		return usuarioEstudiante;
	}

	public void setUsuarioEstudiante(String usuarioEstudiante) {
		this.usuarioEstudiante = usuarioEstudiante;
	}

	public String getContraseñaEstudiante() {
		return contraseñaEstudiante;
	}

	public void setContraseñaEstudiante(String contraseñaEstudiante) {
		this.contraseñaEstudiante = contraseñaEstudiante;
	}
	
	
	
}	
