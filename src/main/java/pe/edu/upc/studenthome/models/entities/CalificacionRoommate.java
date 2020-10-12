package pe.edu.upc.studenthome.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calificacion_roommates")
@IdClass(CalificacionRoommateId.class)
public class CalificacionRoommate {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "estudianteUno_id")
	private Estudiante estudianteUno;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "estudianteDos_id")
	private Estudiante estudianteDos;
	
	@Id
	@JoinColumn(name = "anio_id")
	private String anio;
	
	@Id
	@JoinColumn(name = "mes_id")
	private String mes;
	
	@ManyToOne
	@JoinColumn(name = "puntaje_id")
	private Puntaje puntaje;
	
	@Column(name = "fecha_calificacion_roommate", length = 50 ,nullable = false)
	private String comentario;

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

	public Estudiante getEstudianteUno() {
		return estudianteUno;
	}

	public void setEstudianteUno(Estudiante estudianteUno) {
		this.estudianteUno = estudianteUno;
	}

	public Estudiante getEstudianteDos() {
		return estudianteDos;
	}

	public void setEstudianteDos(Estudiante estudianteDos) {
		this.estudianteDos = estudianteDos;
	}

	public Puntaje getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Puntaje puntaje) {
		this.puntaje = puntaje;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
