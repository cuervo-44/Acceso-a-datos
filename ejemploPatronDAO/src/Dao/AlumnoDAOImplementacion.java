package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.*;
import Entidad.AlumnoEntidad;

public class AlumnoDAOImplementacion implements AlumnoDAO {
	
	private static AlumnoDAOImplementacion instancia;
	private DataSource dataSource;
	
	
	
	private AlumnoDAOImplementacion(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public static AlumnoDAOImplementacion getInstance(DataSource datasource) {
		if(instancia== null) {
			instancia = new AlumnoDAOImplementacion(datasource);
		}
		return instancia;
	}

	@Override
	public void crearAlumno(AlumnoEntidad alumno) {
		String sql = "insert into alumno (codAlumno, nombreAlumno, apellidosAlumno, fechaNacimiento, grupo) values (?, ?, ?, ? ,?)";
		
		Connection connection;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, alumno.getCodAlumno());
			statement.setString(2, alumno.getNombreAlumno());
			statement.setString(3, alumno.getApellidosAlumno());
			statement.setDate(4, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
			statement.setString(5, String.valueOf(alumno.getGrupo()));
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

	@Override
	public AlumnoEntidad obtenerAlumnoPorId(String id) {
		String sql = "SELECT cod_alumno, nombre_alumno, apellidos_alumno, fecha_nacimiento, grupo FROM alumno WHERE cod_alumno = ?";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				return mapearResultSetAAlumno(result);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<AlumnoEntidad> obtenerTodosLosAlumnos() {
		String sql = "SELECT cod_alumno, nombre_alumno, apellidos_alumno, fecha_nacimiento, grupo FROM alumno";

		List<AlumnoEntidad> alumnos = new ArrayList<AlumnoEntidad>();
		 try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				AlumnoEntidad alumno = mapearResultSetAAlumno(result);
				alumnos.add(alumno);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return alumnos;
	}

	@Override
	public void actualizarAlumno(AlumnoEntidad alumno) {
		String sql = "update alumno set nombre_alumno = ?, apellidos_alumno = ? where cod_alumno = ?";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, alumno.getCodAlumno());
			statement.setString(2, alumno.getNombreAlumno());
			statement.setString(3, alumno.getApellidosAlumno());
			statement.setDate(4, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
			statement.setString(5, String.valueOf(alumno.getGrupo()));
			
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void eliminarAlumno(String id) {
		String sql = "delete from alumno where cod_alumno = ?";
		
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1,  id);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private AlumnoEntidad mapearResultSetAAlumno(ResultSet resultSet) throws SQLException {
		 AlumnoEntidad alumno = new AlumnoEntidad();
		 alumno.setCodAlumno(resultSet.getString("cod_alumno"));
		 alumno.setNombreAlumno(resultSet.getString("nombre_alumno"));
		 alumno.setApellidosAlumno(resultSet.getString("apellidos_alumno"));
		 alumno.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
		 alumno.setGrupo(resultSet.getString("grupo").charAt(0));
		 return alumno;
		 }
}
