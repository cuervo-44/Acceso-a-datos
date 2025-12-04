package Dao;

import java.util.List;
import Entidad.ProfesorEntidad;

public interface ProfesorDAO {
	
	public void crearProfesor(ProfesorEntidad profesor);
	public ProfesorEntidad obtenerProfesorPorId(String id);
	public ProfesorEntidad obtenerProfesorPorNombre(String nombre);
	public void actualizarProfesor(ProfesorEntidad profesor);
	public void eliminarProfesor (String id);
	public List<ProfesorEntidad> obetenerModulosPorProfesor(String codProfesor);
	public List<ProfesorEntidad> obtenerTodosLosProfesores();

}
