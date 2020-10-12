package pe.edu.upc.studenthome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import pe.edu.upc.studenthome.models.entities.Estudiante;
import pe.edu.upc.studenthome.services.EstudianteService;
import pe.edu.upc.studenthome.utils.Action;

@Named("estudianteView")
@ViewScoped
public class EstudianteView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Estudiante> estudiantes;

	private Estudiante estudiante;
	// Objeto asociado al rowSelect del datatable
	private Estudiante estudianteSelected;
	// Objeto asociado al search
	private Estudiante estudianteSearch;

	private Action action;
	// Estilo para panelGrid y dataTable
	private String stylePanelEstudiante;
	private String styleTableEstudiante;

	// Disables for commandButton
	private boolean disabledButtonNuevo;
	private boolean disabledButtonGrabar;
	private boolean disabledButtonCancelar;
	private boolean disabledButtonEditar;
	private boolean disabledButtonEliminar;

	// Text in Confirm Dialog
	private String messageConfirmDialog;

	@Inject
	private EstudianteService estudianteService;

	@PostConstruct
	public void init() {
		this.estudianteSearch = new Estudiante();
		this.cleanForm();
		this.loadEstudiantes();
		this.action = Action.NONE;
		this.stateList();
	}

	public void loadEstudiantes() {
		try {
			this.estudiantes = estudianteService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

	public void cleanForm() {
		this.estudiante = new Estudiante();
		this.estudianteSelected = null;
	}

	public void newEstudiante() {
		cleanForm();
		this.action = Action.NEW;
		this.stateNewEdit();
		this.addMessage("Hice click en Nuevo");
	}

	public void saveEstudiante() {
		boolean uniqueNumeroDocumento = true;
		if (this.action == Action.NEW || this.action == Action.EDIT) {
			try {
				// Para verificar que el número de documento es único ESTA PARTE PUEDE HABER
				// ERROR
				Optional<Estudiante> optional = estudianteService.findBydni(estudiante.getPersona().getDni());
				if (optional.isPresent()) {
					if (!optional.get().getId().equals(estudiante.getId())) {
						uniqueNumeroDocumento = false;
					}
				}
				if (uniqueNumeroDocumento == true) {
					if (this.action == Action.NEW) {
						estudianteService.save(this.estudiante);
					} else
						estudianteService.update(this.estudiante);
					cleanForm();
					loadEstudiantes();
					this.action = Action.NONE;
					this.stateList();
				} else { // ESTA PARTE PUEDE HABER ERROR
					this.addMessage("El número de documento: " + estudiante.getPersona().getDni() + " ya existe");
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	public void cancelEstudiante() {
		cleanForm();
		this.stateList();
	}

	public void selectEstudiante(SelectEvent<Estudiante> e) {
		this.estudianteSelected = e.getObject(); // PUEDE HABER ERROR EN ESTA PARTE
		this.messageConfirmDialog = this.estudianteSelected.getPersona().getNombrePersona();
		this.stateSelectRow();
	}

	public void unselectEstudiante(UnselectEvent<Estudiante> e) {
		this.estudianteSelected = null;
		this.stateList();
	} // SIN PIJAMA

	public void editEstudiante() {
		if (this.estudianteSelected != null) {
			this.estudiante = this.estudianteSelected;
			this.action = Action.EDIT;
			this.stateNewEdit();
		}
	}

	public void deleteEstudiante() {
		if (this.estudianteSelected != null) {
			try {
				estudianteService.deleteById(this.estudianteSelected.getId());
				cleanForm();
				loadEstudiantes();
				this.action = Action.NONE;
				this.stateList();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	public void findByNombre() { // CAMBIO POSIBLE ERROR
		if (!this.estudianteSearch.getPersona().getNombrePersona().isEmpty()) {
			try { // CAMBIO POSIBLE ERROR
				this.estudiantes = estudianteService.findByNombre(estudianteSearch.getPersona().getNombrePersona());
				this.stateList();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	public void findByApellido() { // CAMBIO POSIBLE ERROR
		if (!this.estudianteSearch.getPersona().getApellidoPersona().isEmpty()) {
			try { // CAMBIO POSIBLE ERROR
				this.estudiantes = estudianteService.findByApellido(estudianteSearch.getPersona().getApellidoPersona());
				this.stateList();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	public void findBydni() { // CAMBIO POSIBLE ERROR
		if (!this.estudianteSearch.getPersona().getDni().isEmpty()) {
			try {
				this.estudiantes = new ArrayList<>(); // POSIBLE ERROR
				Optional<Estudiante> optional = estudianteService.findBydni(estudianteSearch.getPersona().getDni());
				if (optional.isPresent()) {
					this.estudiantes.add(optional.get());
				}
				this.stateList();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	public void cleanByNombres() { // GETPERSONA? O SETPERSONA?
		this.estudianteSearch.getPersona().setNombrePersona("");
		loadEstudiantes();
		this.stateList();
	}

	public void cleanByApellidos() { // GETPERSONA? O SETPERSONA?
		this.estudianteSearch.getPersona().setApellidoPersona("");
		loadEstudiantes();
		this.stateList();
	}

	public void cleanBydni() { // GETPERSONA? O SETPERSONA?
		this.estudianteSearch.getPersona().setDni("");
		loadEstudiantes();
		this.stateList();
	}

	// State on Application
	public void stateList() {
		this.stylePanelEstudiante = "display:none;";
		this.styleTableEstudiante = "display:block;";
		this.disabledButtonNuevo = false;
		this.disabledButtonGrabar = true;
		this.disabledButtonCancelar = true;
		this.disabledButtonEditar = true;
		this.disabledButtonEliminar = true;
	}

	public void stateNewEdit() {
		this.stylePanelEstudiante = "display:block;";
		this.styleTableEstudiante = "display:none;";
		this.disabledButtonNuevo = true;
		this.disabledButtonGrabar = false;
		this.disabledButtonCancelar = false;
		this.disabledButtonEditar = true;
		this.disabledButtonEliminar = true;
	}

	public void stateSelectRow() {
		this.stylePanelEstudiante = "display:none;";
		this.styleTableEstudiante = "display:block;";
		this.disabledButtonNuevo = false;
		this.disabledButtonGrabar = true;
		this.disabledButtonCancelar = true;
		this.disabledButtonEditar = false;
		this.disabledButtonEliminar = false;
	}

	// Método que muestra los mensajes
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public EstudianteService getEstudianteService() {
		return estudianteService;
	}
	
	public Estudiante getEstudiante() {
		return estudiante;
	}

	public String getStyleTableEstudiante() {
		return styleTableEstudiante;
	}

	public String getStylePanelEstudiante() {
		return stylePanelEstudiante;
	}

	public boolean isDisabledButtonNuevo() {
		return disabledButtonNuevo;
	}

	public boolean isDisabledButtonGrabar() {
		return disabledButtonGrabar;
	}

	public boolean isDisabledButtonCancelar() {
		return disabledButtonCancelar;
	}

	public boolean isDisabledButtonEditar() {
		return disabledButtonEditar;
	}

	public boolean isDisabledButtonEliminar() {
		return disabledButtonEliminar;
	}

	public String getMessageConfirmDialog() {
		return messageConfirmDialog;
	}

	public Estudiante getEstudianteSearch() {
		return estudianteSearch;
	}

}
