package pe.edu.upc.studenthome.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class CalificacionId implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long arrendador;
	private Long estudiante;
	private String anio;
	private String mes;
	
	public CalificacionId() {
		
	}
	public CalificacionId(Long arrendador, Long estudiante, 
			String anio, String mes) {
		super();
		this.arrendador = arrendador;
		this.estudiante = estudiante;
		this.anio = anio;
		this.mes = mes;
	}
	public Long getArrendador() {
		return arrendador;
	}
	public void setArrendador(Long arrendador) {
		this.arrendador = arrendador;
	}
	public Long getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Long estudiante) {
		this.estudiante = estudiante;
	}
	
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
	@Override
	public int hashCode() {
		return Objects.hash(arrendador, estudiante);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        CalificacionId calificacionId = (CalificacionId) obj;
        if (this.arrendador != calificacionId.arrendador ||
        	this.anio != calificacionId.anio || this.mes != calificacionId.mes) 
        	return false;
        return this.estudiante == calificacionId.estudiante;
	}
	
	
}	
