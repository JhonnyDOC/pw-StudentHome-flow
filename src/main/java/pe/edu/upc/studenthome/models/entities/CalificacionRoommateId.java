package pe.edu.upc.studenthome.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class CalificacionRoommateId implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long estudianteUno;
	private Long estudianteDos;
	private String anio;
	private String mes;
	
	public CalificacionRoommateId() {
		
	}
	
	public CalificacionRoommateId(Long estudianteUno, Long estudianteDos,
			 					  String anio, String mes) {
		super();
		this.estudianteUno = estudianteUno;
		this.estudianteDos = estudianteDos;
		this.anio = anio;
		this.mes = mes;
	}

	public Long getEstudianteUno() {
		return estudianteUno;
	}

	public void setEstudianteUno(Long estudianteUno) {
		this.estudianteUno = estudianteUno;
	}

	public Long getEstudianteDos() {
		return estudianteDos;
	}

	public void setEstudianteDos(Long estudianteDos) {
		this.estudianteDos = estudianteDos;
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
		return Objects.hash(estudianteUno, estudianteDos, anio, mes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        CalificacionRoommateId calificacionRoommateId = (CalificacionRoommateId) obj;
        if (this.estudianteUno != calificacionRoommateId.estudianteUno ||
        		this.anio != calificacionRoommateId.anio || 
        		this.mes != calificacionRoommateId.mes) 
        	return false;
        return this.estudianteDos == calificacionRoommateId.estudianteDos;
	}
	
	
}
