package proyectoIncicioHibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor {
	
	@Id
	@Column(name="cod_profesor")
	private String cod_profesor;
	@Column(name="nombre_profesor")
	private String nombreProfesor;
	@Column(name="ciudad")
	private String ciudad;
	
	
	
	public Profesor() {
		super();
	}



	public Profesor(String cod_profesor, String nombreProfesor, String ciudad) {
		super();
		this.cod_profesor = cod_profesor;
		this.nombreProfesor = nombreProfesor;
		this.ciudad = ciudad;
	}



	public String getCod_profesor() {
		return cod_profesor;
	}



	public void setCod_profesor(String cod_profesor) {
		this.cod_profesor = cod_profesor;
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



	@Override
	public String toString() {
		return "Profesor [cod_profesor=" + cod_profesor + ", nombreProfesor=" + nombreProfesor + ", ciudad=" + ciudad
				+ "]";
	}
	
	
	
	
	
}
