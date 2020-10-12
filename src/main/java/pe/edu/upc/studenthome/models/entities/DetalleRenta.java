package pe.edu.upc.studenthome.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_rentas")
@IdClass(DetalleRentaId.class)
public class DetalleRenta {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "renta_id")
	private Renta renta;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;
	
	@Column(name = "precio_subtotal", nullable = false)
	private Float precioSubtotal;

	public Renta getRenta() {
		return renta;
	}

	public void setRenta(Renta renta) {
		this.renta = renta;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Float getPrecioSubtotal() {
		return precioSubtotal;
	}

	public void setPrecioSubtotal(Float precioSubtotal) {
		this.precioSubtotal = precioSubtotal;
	}
	
}
