package pe.edu.upc.studenthome.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "historiales")
@IdClass(HistorialId.class)
public class Historial {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "arrendador_id")
	private Arrendador arrendador;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;
	
	@Id
	@JoinColumn(name = "anio_id")
	private String anio;
	
	@Id
	@JoinColumn(name = "mes_id")
	private String mes;
	
	@Column(name = "dias_retraso", nullable = false)
	private Integer diasRetraso;
	
	@Column(name = "fecha_pago", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaPago;
	
	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Arrendador getArrendador() {
		return arrendador;
	}

	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public Integer getDiasRetraso() {
		return diasRetraso;
	}

	public void setDiasRetraso(Integer diasRetraso) {
		this.diasRetraso = diasRetraso;
	}


	
}
