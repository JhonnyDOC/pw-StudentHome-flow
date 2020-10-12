package pe.edu.upc.studenthome.models.entities;

import java.util.Date;

public class JhonnyOcaña {

	private Float id;
	private String nombre;
	private Integer edad;
	private Date FechaNacimiento;
	
	public Float getId() {
		return id;
	}
	public void setId(Float id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
}
