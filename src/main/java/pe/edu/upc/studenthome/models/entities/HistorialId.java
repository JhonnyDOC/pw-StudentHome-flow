package pe.edu.upc.studenthome.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class HistorialId implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long arrendador;
	private Long estudiante;
	private String anio;
	private String mes;
	
	public HistorialId() {
		
	}
	public HistorialId(Long arrendador, Long estudiante,String anio, String mes) {
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
		return Objects.hash(arrendador, estudiante, anio, mes);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        HistorialId historialId = (HistorialId) obj;
        if (this.arrendador != historialId.arrendador ||
        		this.anio != historialId.anio || this.mes != historialId.mes) 
        	return false;
        return this.estudiante == historialId.estudiante;
	}
	
}
