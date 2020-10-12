package pe.edu.upc.studenthome.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "puntajes")
public class Puntaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_puntaje", length = 10, nullable = false)
	private String nombrePuntaje;
	
	@OneToMany(mappedBy = "puntaje")
	private List<Calificacion> calificaciones;
	
	@OneToMany(mappedBy = "puntaje")
	private List<CalificacionRoommate> calificacionesRoommates;
	
	public Puntaje () {
		calificaciones = new ArrayList<Calificacion>();
		calificacionesRoommates = new ArrayList<CalificacionRoommate>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombrePuntaje() {
		return nombrePuntaje;
	}

	public void setNombrePuntaje(String nombrePuntaje) {
		this.nombrePuntaje = nombrePuntaje;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public List<CalificacionRoommate> getCalificacionesRoommates() {
		return calificacionesRoommates;
	}

	public void setCalificacionesRoommates(List<CalificacionRoommate> calificacionesRoommates) {
		this.calificacionesRoommates = calificacionesRoommates;
	}
	
}
