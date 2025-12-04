package Servicios;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import Dao.ProfesorDAOImplementacion;
import Dto.ProfesorDTO;
import Entidad.ProfesorEntidad;

public class ProfesorService {
	 private static ProfesorService instancia;
	 private ProfesorDAOImplementacion profesorDao;
	 
	 private ProfesorService(DataSource dataSource) {
	        this.profesorDao = ProfesorDAOImplementacion.getInstance(dataSource);
	    }

	    public static ProfesorService getInstance(DataSource dataSource) {
	        if (instancia == null) {
	            instancia = new ProfesorService(dataSource);
	        }
	        return instancia;
	    }
	
	public void crearProfesor(ProfesorDTO profesorDto) {
		ProfesorEntidad profesor = mapearDtoAEntidad(profesorDto);
        profesorDao.crearProfesor(profesor);
	}
	public ProfesorDTO obtenerProfesorPorCodigo (String codProfesor) {
		 ProfesorEntidad profesor = profesorDao.obtenerProfesorPorId(codProfesor);
	        if (profesor != null) {
	            return mapearEntidadADto(profesor);
	        }
	        return null;
	}
	
	public ProfesorDTO obtenerProfesorPorNombre(String nombre) {
		
		 ProfesorEntidad profesor = profesorDao.obtenerProfesorPorNombre(nombre);
	        if (profesor != null) {
	            return mapearEntidadADto(profesor);
	        }
	        return null;
	}
	
	public List<ProfesorDTO> obtenerTodosLosProfesores() {
		List<ProfesorEntidad> profesores = profesorDao.obtenerTodosLosProfesores();
        List<ProfesorDTO> profesoresDto = new ArrayList<>();

        for (ProfesorEntidad profesor : profesores) {
            profesoresDto.add(mapearEntidadADto(profesor));
        }
        return profesoresDto;
	}
	
	public void actualizarProfesor(ProfesorDTO profesor ) {
		ProfesorEntidad profesorExistente = profesorDao.obtenerProfesorPorId(profesor.getCodProfesor());
        if (profesorExistente != null) {
            ProfesorEntidad profesorActualizado = mapearDtoAEntidad(profesor);
            profesorDao.actualizarProfesor(profesorActualizado);
        }
	}
	public void eliminarProfesor(String codProfesor) {
		if (codProfesor != null) {
			profesorDao.eliminarProfesor(codProfesor);
		}
	}
	
	private ProfesorEntidad mapearDtoAEntidad(ProfesorDTO profesorDto) {
        ProfesorEntidad profesor = new ProfesorEntidad();
        profesor.setCodProfesor(profesorDto.getCodProfesor());
        profesor.setNombreProfesor(profesorDto.getNombreProfesor());
        profesor.setCiudad(profesorDto.getCiudad());
        //profesorDto.setListaModulos(profesorDto.getListaModulos());
        return profesor;
    }

    
    private ProfesorDTO mapearEntidadADto(ProfesorEntidad profesor) {
        ProfesorDTO profesorDto = new ProfesorDTO();
        profesorDto.setCodProfesor(profesor.getCodProfesor());
        profesorDto.setNombreProfesor(profesor.getNombreProfesor());
        profesorDto.setCiudad(profesor.getCiudad());
        return profesorDto;
    }
}
