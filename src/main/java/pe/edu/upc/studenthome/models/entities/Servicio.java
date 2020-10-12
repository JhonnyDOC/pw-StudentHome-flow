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
@Table(name = "servicios")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_servicio", length = 20, nullable = false)
	private String nombreServicio;
	
	@OneToMany(mappedBy = "servicio")
	private List<HabitacionServicio> habitacionServicios;
	
	public Servicio() {
		habitacionServicios = new ArrayList<HabitacionServicio>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public List<HabitacionServicio> getHabitacionServicios() {
		return habitacionServicios;
	}

	public void setHabitacionServicios(List<HabitacionServicio> habitacionServicios) {
		this.habitacionServicios = habitacionServicios;
	}
}
