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
@Table(name = "tipo_inmuebles")
public class TipoInmueble {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_tipo_inmueble", length = 30, nullable = false)
	private String nombreTipoInmueble;
	
	@OneToMany(mappedBy = "tipoInmueble")
	private List<Habitacion> habitaciones;
	
	public TipoInmueble() {
		habitaciones = new ArrayList<Habitacion>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreTipoInmueble() {
		return nombreTipoInmueble;
	}

	public void setNombreTipoInmueble(String nombreTipoInmueble) {
		this.nombreTipoInmueble = nombreTipoInmueble;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
}
