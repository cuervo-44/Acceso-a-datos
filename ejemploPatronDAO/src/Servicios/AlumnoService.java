package Servicios;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Dao.AlumnoDAOImplementacion;
import Dto.AlumnoDTO;
import Entidad.AlumnoEntidad;

public class AlumnoService {

    private static AlumnoService instancia;
    private AlumnoDAOImplementacion alumnoDao;

    private AlumnoService(DataSource dataSource) {
        this.alumnoDao = AlumnoDAOImplementacion.getInstance(dataSource);
    }

    public static AlumnoService getInstance(DataSource dataSource) {
        if (instancia == null) {
            instancia = new AlumnoService(dataSource);
        }
        return instancia;
    }

    
    private AlumnoEntidad mapearDtoAEntidad(AlumnoDTO alumnoDto) {
        AlumnoEntidad alumno = new AlumnoEntidad();
        alumno.setCodAlumno(alumnoDto.getCodAlumno());
        alumno.setNombreAlumno(alumnoDto.getNombreAlumno());
        alumno.setApellidosAlumno(alumnoDto.getApellidosAlumno());
        alumno.setFechaNacimiento(convertirEdadAFecha(alumnoDto.getEdad()));
        alumno.setGrupo(alumnoDto.getGrupo());
        return alumno;
    }

    
    private AlumnoDTO mapearEntidadADto(AlumnoEntidad alumno) {
        AlumnoDTO alumnoDto = new AlumnoDTO();
        alumnoDto.setCodAlumno(alumno.getCodAlumno());
        alumnoDto.setNombreAlumno(alumno.getNombreAlumno());
        alumnoDto.setApellidosAlumno(alumno.getApellidosAlumno());
        alumnoDto.setEdad(calcularEdad(alumno.getFechaNacimiento()));
        alumnoDto.setGrupo(alumno.getGrupo());
        return alumnoDto;
    }

    public void crearAlumno(AlumnoDTO alumnoDto) {
        AlumnoEntidad alumno = mapearDtoAEntidad(alumnoDto);
        alumnoDao.crearAlumno(alumno);
    }

    public AlumnoDTO obtenerAlumnoPorId(String id) {
        AlumnoEntidad alumno = alumnoDao.obtenerAlumnoPorId(id);
        if (alumno != null) {
            return mapearEntidadADto(alumno);
        }
        return null;
    }

    public List<AlumnoDTO> obtenerTodosLosAlumnos() {
        List<AlumnoEntidad> alumnos = alumnoDao.obtenerTodosLosAlumnos();
        List<AlumnoDTO> alumnosDto = new ArrayList<>();

        for (AlumnoEntidad alumno : alumnos) {
            alumnosDto.add(mapearEntidadADto(alumno));
        }
        return alumnosDto;
    }

    public void actualizarAlumno(AlumnoDTO alumnoDto) {
        AlumnoEntidad alumnoExistente = alumnoDao.obtenerAlumnoPorId(alumnoDto.getCodAlumno());
        if (alumnoExistente != null) {
            AlumnoEntidad alumnoActualizado = mapearDtoAEntidad(alumnoDto);
            alumnoDao.actualizarAlumno(alumnoActualizado);
        }
    }

    public void eliminarAlumno(String id) {
        if (id != null) {
            alumnoDao.eliminarAlumno(id);
        }
    }

    private Date convertirEdadAFecha(int edad) {
        LocalDate nacimiento = LocalDate.now().minusYears(edad);
        return (Date) Date.from(nacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private int calcularEdad(Date fecha) {
        LocalDate nacimiento = new java.util.Date(fecha.getTime())
                .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(nacimiento, LocalDate.now()).getYears();
    }
}