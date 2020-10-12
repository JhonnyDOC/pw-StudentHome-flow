package pe.edu.upc.studenthome.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class DetalleRentaId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long estudiante;
	private Integer renta;
	
	public DetalleRentaId() {
	}
	public DetalleRentaId(Long estudiante, Integer renta) {
		super();
		this.estudiante = estudiante;
		this.renta = renta;
	}
	public Long getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Long estudiante) {
		this.estudiante = estudiante;
	}
	public Integer getRenta() {
		return renta;
	}
	public void setRenta(Integer renta) {
		this.renta = renta;
	}
	@Override
	public int hashCode() {
		return Objects.hash(estudiante, renta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        DetalleRentaId detalleRentaId = (DetalleRentaId) obj;
        if (this.estudiante != detalleRentaId.estudiante) 
        	return false;
        return this.renta == detalleRentaId.renta;
	}
	
	
}
