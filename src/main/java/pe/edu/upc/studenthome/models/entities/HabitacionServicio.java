package pe.edu.upc.studenthome.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "habitacion_servicios")
@IdClass(HabitacionServicioId.class)
public class HabitacionServicio {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "servicio_id")
	private Servicio servicio;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "habitacion_id")
	private Habitacion habitacion;

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
}	
