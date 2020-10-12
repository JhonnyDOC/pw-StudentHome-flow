package pe.edu.upc.studenthome.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numero_vivienda_ext", nullable = false)
	private Integer numeroViviendaExterno;
	
	@Column(name = "numero_vivienda_interno", nullable = true)
	private Integer numeroViviendaInterno;
	
	@Column(name = "numero_habitaciones", nullable = false)
	private Integer numeroHabitaciones;
	
	@Column(name = "direccion", length = 50, nullable = false)
	private String direccion;
	
	@Column(name = "metros_cuadrados", nullable = false)
	private Integer metrosCuadrados;
	
	@Column(name = "precio", nullable = false)
	private Float precio;
	
	@Column(name = "descripcion_inmueble", length = 50, nullable = false)
	private String descripcionInmueble;
	
	@Column(name = "descripcion_amueblado", length = 50, nullable = true)
	private String descripcionAmueblado;
	
	@Column(name = "imagen_1", nullable = false)
	private String imagen1;
	
	@Column(name = "imagen_2", nullable = true)
	private String imagen2;
	
	@Column(name = "imagen_3", nullable = true)
	private String imagen3;
	
	@Column(name = "imagen_4", nullable = true)
	private String imagen4;
	
	@ManyToOne
	@JoinColumn(name = "arrendador_id")
	private Arrendador arrendador;
	
	@ManyToOne
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;
	
	@ManyToOne
	@JoinColumn(name = "tipo_inmueble_id")
	private TipoInmueble tipoInmueble;
	
	@OneToMany(mappedBy = "habitacion")
	private List<HabitacionServicio> habitacionServicios;
	
	@OneToMany(mappedBy = "habitacion")
	private List<Renta> rentas;
	
	public Habitacion() {
		habitacionServicios = new ArrayList<HabitacionServicio>();
		rentas = new ArrayList<Renta>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroViviendaExterno() {
		return numeroViviendaExterno;
	}

	public void setNumeroViviendaExterno(Integer numeroViviendaExterno) {
		this.numeroViviendaExterno = numeroViviendaExterno;
	}

	public Integer getNumeroViviendaInterno() {
		return numeroViviendaInterno;
	}

	public void setNumeroViviendaInterno(Integer numeroViviendaInterno) {
		this.numeroViviendaInterno = numeroViviendaInterno;
	}

	public Integer getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(Integer numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Integer metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getDescripcionInmueble() {
		return descripcionInmueble;
	}

	public void setDescripcionInmueble(String descripcionInmueble) {
		this.descripcionInmueble = descripcionInmueble;
	}

	public String getDescripcionAmueblado() {
		return descripcionAmueblado;
	}

	public void setDescripcionAmueblado(String descripcionAmueblado) {
		this.descripcionAmueblado = descripcionAmueblado;
	}

	public String getImagen1() {
		return imagen1;
	}

	public void setImagen1(String imagen1) {
		this.imagen1 = imagen1;
	}

	public String getImagen2() {
		return imagen2;
	}

	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}

	public String getImagen3() {
		return imagen3;
	}

	public void setImagen3(String imagen3) {
		this.imagen3 = imagen3;
	}

	public String getImagen4() {
		return imagen4;
	}

	public void setImagen4(String imagen4) {
		this.imagen4 = imagen4;
	}

	public Arrendador getArrendador() {
		return arrendador;
	}

	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public TipoInmueble getTipoInmueble() {
		return tipoInmueble;
	}

	public void setTipoInmueble(TipoInmueble tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}

	public List<HabitacionServicio> getHabitacionServicios() {
		return habitacionServicios;
	}

	public void setHabitacionServicios(List<HabitacionServicio> habitacionServicios) {
		this.habitacionServicios = habitacionServicios;
	}

	public List<Renta> getRentas() {
		return rentas;
	}

	public void setRentas(List<Renta> rentas) {
		this.rentas = rentas;
	}
	
}
