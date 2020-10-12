package pe.edu.upc.studenthome.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class HabitacionServicioId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer servicio;
	private Integer habitacion;
	
	public HabitacionServicioId() {
	}
	
	public HabitacionServicioId(Integer servicio, Integer habitacion) {
		super();
		this.servicio = servicio;
		this.habitacion = habitacion;
	}

	public Integer getServicio() {
		return servicio;
	}

	public void setServicio(Integer servicio) {
		this.servicio = servicio;
	}

	public Integer getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Integer habitacion) {
		this.habitacion = habitacion;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(servicio, habitacion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        HabitacionServicioId habitacionServicioId = (HabitacionServicioId) obj;
        if (this.servicio != habitacionServicioId.servicio) 
        	return false;
        return this.habitacion == habitacionServicioId.habitacion;
	}
}
