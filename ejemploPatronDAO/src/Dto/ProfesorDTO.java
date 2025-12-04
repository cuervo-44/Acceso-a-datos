package Dto;

import java.util.List;

public class ProfesorDTO {
	private String codProfesor;
	private String nombreProfesor;
	private String ciudad;
	private List<String> listaModulos;
	
	public ProfesorDTO(String codProfesor, String nombreProfesor, String ciudad, List<String> listaModulos) {
		super();
		this.codProfesor = codProfesor;
		this.nombreProfesor = nombreProfesor;
		this.ciudad = ciudad;
		this.listaModulos = listaModulos;
	}
	public ProfesorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCodProfesor() {
		return codProfesor;
	}
	public void setCodProfesor(String codProfesor) {
		this.codProfesor = codProfesor;
	}
	public String getNombreProfesor() {
		return nombreProfesor;
	}
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public List<String> getListaModulos() {
		return listaModulos;
	}
	public void setListaModulos(List<String> listaModulos) {
		this.listaModulos = listaModulos;
	}
	@Override
	public String toString() {
		return "ProfesorDTO [codProfesor=" + codProfesor + ", nombreProfesor=" + nombreProfesor + ", ciudad=" + ciudad
				+ ", listaModulos=" + listaModulos + "]";
	}
	
	
	
	
}
