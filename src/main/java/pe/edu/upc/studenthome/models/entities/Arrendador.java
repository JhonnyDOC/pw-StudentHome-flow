package pe.edu.upc.studenthome.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "arrendadores")
public class Arrendador {
	
	@Id
	private Long id;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private Persona persona;
	
	@Column(name = "ruc", length = 11, nullable = false)
	private String ruc;
	
	@Column(name = "descripcion", length = 30, nullable = true)
	private String descripcion;
	
	@OneToMany(mappedBy = "arrendador")
	private List<Habitacion> habitaciones;
	
	@OneToMany(mappedBy = "arrendador")
	private List<Renta> rentas;
	
	@OneToMany(mappedBy = "arrendador")
	private List<Historial> historiales;
	
	@OneToMany(mappedBy = "arrendador")
	private List<Calificacion> calificaciones;
	
	@ManyToOne
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;
	
	@Transient
	private Integer distritoId;
	
	public Arrendador() {
		calificaciones = new ArrayList<Calificacion>();
		historiales = new ArrayList<Historial>();
		rentas = new ArrayList<Renta>();
		habitaciones = new ArrayList<Habitacion>();
		this.distritoId = 0;
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

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<Renta> getRentas() {
		return rentas;
	}

	public void setRentas(List<Renta> rentas) {
		this.rentas = rentas;
	}

	public List<Historial> getHistoriales() {
		return historiales;
	}

	public void setHistoriales(List<Historial> historiales) {
		this.historiales = historiales;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
		if (this.distrito != null) {
			this.distritoId = this.distrito.getId();
		}
	}

	public Integer getDistritoId() {
		if(this.distritoId <= 0 && this.distrito != null) {
			this.distritoId = this.distrito.getId();
		}
		return distritoId;
	}

	public void setDistritoId(Integer distritoId) {
		this.distritoId = distritoId;
	}
	
	
	
}
