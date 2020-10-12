package pe.edu.upc.studenthome.utils;

import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import pe.edu.upc.studenthome.models.entities.Distrito;
import pe.edu.upc.studenthome.services.DistritoService;

@FacesConverter("converter.DistritoConverter")
public class DistritoConverter implements Converter<Distrito> {
	
	@Inject
	private DistritoService distritoService;

	@Override
	public Distrito getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("NAUJ (getAsObject) : " + value);
		if(value != null && !value.isEmpty()) {
			try {
				Integer id = Integer.parseInt(value);
				System.out.println("NAUJ (getAsObject) id : " + id);
				Optional<Distrito> optional = distritoService.findById(id);
				if(optional.isPresent()) {
					return optional.get();
				}
				return null;
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
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
