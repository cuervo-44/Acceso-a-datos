package Dto;

import java.io.Serializable;

public class AlumnoDTO implements Serializable {
	private String codAlumno;
	private String nombreAlumno;
	private String apellidosAlumno;
	private int edad;
	private char grupo;
	
	public AlumnoDTO(String codAlumno, String nombreAlumno, String apellidosAlumno, int edad, char grupo) {
		super();
		this.codAlumno = codAlumno;
		this.nombreAlumno = nombreAlumno;
		this.apellidosAlumno = apellidosAlumno;
		this.edad = edad;
		this.grupo = grupo;
	}
	
	

	public AlumnoDTO() {
		// TODO Auto-generated constructor stub
	}



	public String getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getApellidosAlumno() {
		return apellidosAlumno;
	}

	public void setApellidosAlumno(String apellidosAlumno) {
		this.apellidosAlumno = apellidosAlumno;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getGrupo() {
		return grupo;
	}

	public void setGrupo(char grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "AlumnoDTO [codAlumno=" + codAlumno + ", nombreAlumno=" + nombreAlumno + ", apellidosAlumno="
				+ apellidosAlumno + ", fechaNacimiento=" + edad + ", grupo=" + grupo + "]";
	}
	
	

}
