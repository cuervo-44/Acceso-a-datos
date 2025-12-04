package Principal;

import javax.sql.DataSource;

import Servicios.AlumnoService;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		DataSource ds = configurarDataSource();
		
		AlumnoServices alumnoService = AlumnoService.getInstancia(ds);
		
		List <AlumnoDTO> alumnos = alumnoService.obtenerTodosLosAlumnos();
		
		for (AlumnoDTO)
		
		
	}
	
	private static DataSource configurarDataSource () {
		
	}

}
