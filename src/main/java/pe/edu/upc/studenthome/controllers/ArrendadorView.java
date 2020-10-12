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

import pe.edu.upc.studenthome.models.entities.Arrendador;
import pe.edu.upc.studenthome.models.entities.Distrito;
import pe.edu.upc.studenthome.services.ArrendadorServices;
import pe.edu.upc.studenthome.services.DistritoService;
import pe.edu.upc.studenthome.utils.Action;

@Named("arrendadorView")
@ViewScoped
public class ArrendadorView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Arrendador> arrendadores;

	// Objeto asociado al formulario del arrendador
	private Arrendador arrendador;
	// Objeto asociado al rowSelect del datatable
	private Arrendador arrendadorSelected;
	// Objeto asociado al search
	private Arrendador arrendadorSearch;

	private List<Distrito> distritos;
	private Distrito distritoSelected;

	private Action action;
	// Estilo para panelGrid y dataTable
	private String stylePanelArrendador;
	private String styleTableArrendador;

	// Disables for commandButton
	private boolean disabledButtonNuevo;
	private boolean disabledButtonGrabar;
	private boolean disabledButtonCancelar;
	private boolean disabledButtonEditar;
	private boolean disabledButtonEliminar;

	// Text in Confirm Dialog
	private String messageConfirmDialog;

	@Inject
	private ArrendadorServices arrendadorService;

	@Inject
	private DistritoService distritoService;

	@PostConstruct
	public void init() {
		this.arrendadorSearch = new Arrendador();
		this.cleanForm();
		this.loadArrendadores();
		this.loadDistritos();
		this.action = Action.NONE;
		this.stateList();
	}

	public void loadArrendadores() {
		try {
			this.arrendadores = arrendadorService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

	public void loadDistrito(Integer id) {
		try {
			this.distritoSelected = (distritoService.findById(id)).get();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void loadDistritos() {
		try {
			this.distritos = distritoService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void cleanForm() {
		this.arrendador = new Arrendador();
		this.arrendadorSelected = null;
	}

	// Metodo cuando se hace click en el boton Nuevo
	public void newArrendador() {
		cleanForm();
		this.action = Action.NEW;
		this.stateNewEdit();
		this.addMessage("Hice click en Nuevo");
	}

	// Funciona cuando se cambia el distrito
	public void changeDistrito() {
		if (this.arrendador.getDistrito() != null) {
			if (!this.arrendador.getDistrito().getId().equals(this.arrendador.getDistritoId())) {
				loadDistrito(this.arrendador.getDistritoId());
				this.arrendador.setDistrito(this.distritoSelected);
			}
		} // Cuando es un nuevo Arrendador
		else {
			loadDistrito(this.arrendador.getDistritoId());
			this.arrendador.setDistrito(this.distritoSelected);
		}
	}

	// Método cuando se hace click en el boton Grabar
	public void saveArrendador() {
		boolean uniqueNumeroDocumento = true;
		if (this.action == Action.NEW || this.action == Action.EDIT) {
			try {
				// Para verificar que el número de documento es único ESTA PARTE PUEDE HABER
				// ERROR
				Optional<Arrendador> optional = arrendadorService.findBydni(arrendador.getPersona().getDni());
				if (optional.isPresent()) {
					if (!optional.get().getId().equals(arrendador.getId())) {
						uniqueNumeroDocumento = false;
					}
				}
				if (uniqueNumeroDocumento == true) {
					changeDistrito();
					if (this.action == Action.NEW) {
						arrendadorService.save(this.arrendador);
					}
					else
						arrendadorService.update(this.arrendador);
					cleanForm();
					loadArrendadores();
					this.action = Action.NONE;
					this.stateList();
				} else { // ESTA PARTE PUEDE HABER ERROR
					this.addMessage("El número de documento: " + arrendador.getPersona().getDni() + " ya existe");
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	// Método cuando se hace click en el boton Cancelar
	public void cancelArrendador() {
		cleanForm();
		this.stateList();
	}

	// Metodo que se ejecuta cuando el evento rowSelect ocurra
	public void selectArrendador(SelectEvent<Arrendador> e) {
		this.arrendadorSelected = e.getObject(); // PUEDE HABER ERROR EN ESTA PARTE
		this.messageConfirmDialog = this.arrendadorSelected.getPersona().getNombrePersona();
		this.stateSelectRow();
	}

	// Metodo que se ejecuta cuando el evento rowUnselect ocurra
	public void unselectArrendador(UnselectEvent<Arrendador> e) {
		this.arrendadorSelected = null;
		this.stateList();
	}


	// Método que se ejecuta cuando hago click en el boton Editar
	public void editArrendador() {
		if (this.arrendadorSelected != null) {
			this.arrendador = this.arrendadorSelected;
			this.action = Action.EDIT;
			this.stateNewEdit();
		}
	}

	// Método que se ejecuta cuando hago click en el boton Eliminar
	public void deleteArrendador() {
		if (this.arrendadorSelected != null) {
			try {
				arrendadorService.deleteById(this.arrendadorSelected.getId());
				cleanForm();
				loadArrendadores();
				this.action = Action.NONE;
				this.stateList();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	// Metodo para encontrar al arrendador por Nombre
	public void findByNombre() { // CAMBIO POSIBLE ERROR
		if (!this.arrendadorSearch.getPersona().getNombrePersona().isEmpty()) {
			try { // CAMBIO POSIBLE ERROR
				this.arrendadores = arrendadorService.findByNombre(arrendadorSearch.getPersona().getNombrePersona());
				this.stateList();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	// Metodo para encontrar al arrendador por Apellido
	public void findByApellido() { // CAMBIO POSIBLE ERROR
		if (!this.arrendadorSearch.getPersona().getApellidoPersona().isEmpty()) {
			try { // CAMBIO POSIBLE ERROR
				this.arrendadores = arrendadorService.findByApellido(arrendadorSearch.getPersona().getApellidoPersona());
				this.stateList();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	// Metodo para encontrar al arrendador por DNI
	public void findBydni() { // CAMBIO POSIBLE ERROR
		if (!this.arrendadorSearch.getPersona().getDni().isEmpty()) {
			try {
				this.arrendadores = new ArrayList<>(); // POSIBLE ERROR
				Optional<Arrendador> optional = arrendadorService.findBydni(arrendadorSearch.getPersona().getDni());
				if (optional.isPresent()) {
					this.arrendadores.add(optional.get());
				}
				this.stateList();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	// LIMPIAR NOMBRES ARRENDADORES
	public void cleanByNombres() { // GETPERSONA? O SETPERSONA?
		this.arrendadorSearch.getPersona().setNombrePersona("");
		loadArrendadores();
		this.stateList();
	}

	// LIMPIAR APELLIDOS ARRENDADORES
	public void cleanByApellidos() { // GETPERSONA? O SETPERSONA?
		this.arrendadorSearch.getPersona().setApellidoPersona("");
		loadArrendadores();
		this.stateList();
	}

	// LIMPIAR DNI ARRENDADORES
	public void cleanBydni() { // GETPERSONA? O SETPERSONA?
		this.arrendadorSearch.getPersona().setDni("");
		loadArrendadores();
		this.stateList();
	}

	// State on Application
	public void stateList() {
		this.stylePanelArrendador = "display:none;";
		this.styleTableArrendador = "display:block;";
		this.disabledButtonNuevo = false;
		this.disabledButtonGrabar = true;
		this.disabledButtonCancelar = true;
		this.disabledButtonEditar = true;
		this.disabledButtonEliminar = true;
	}

	public void stateNewEdit() {
		this.stylePanelArrendador = "display:block;";
		this.styleTableArrendador = "display:none;";
		this.disabledButtonNuevo = true;
		this.disabledButtonGrabar = false;
		this.disabledButtonCancelar = false;
		this.disabledButtonEditar = true;
		this.disabledButtonEliminar = true;
	}

	public void stateSelectRow() {
		this.stylePanelArrendador = "display:none;";
		this.styleTableArrendador = "display:block;";
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

	public ArrendadorServices getArrendadorServices() {
		return arrendadorService;
	}

	public List<Arrendador> getArrendadores() {
		return arrendadores;
	}

	public Arrendador getArrendador() {
		return arrendador;
	}

	public List<Distrito> getDistritos() {
		return distritos;
	}

	public DistritoService getDistritoService() {
		return distritoService;
	}

	public String getStyleTableArrendador() {
		return styleTableArrendador;
	}

	public String getStylePanelArrendador() {
		return stylePanelArrendador;
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

	public Arrendador getArrendadorSearch() {
		return arrendadorSearch;
	}

}
