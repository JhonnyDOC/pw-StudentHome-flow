package pe.edu.upc.studenthome.utils;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import pe.edu.upc.studenthome.controllers.DistritoMenuView;
import pe.edu.upc.studenthome.models.entities.Distrito;

@FacesConverter("distritoMenuConverter")
public class DistritoMenuConverter implements Converter<Distrito> , Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DistritoMenuView distritoMenuView;
	
	@Override
	public Distrito getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("NAUJ (getAsObject) : " + value);
		System.out.println("NAUJ (getAsObject) LIST : " + distritoMenuView);
		System.out.println("NAUJ (getAsObject) LIST : " + distritoMenuView.getDistritos());
		if (value == null) {
            return null;
        }
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Distrito value) {
		if(value != null) {
			System.out.println("NAUJ (getAsString): " + value.getNombreDistrito());
			return String.valueOf(value.getId());
		} else {
			System.out.println("NAUJ (getAsString): NULL" );
			return "";
		}
	}

}
