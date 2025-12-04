package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import Entidad.ProfesorEntidad;

public class ProfesorDAOImplementacion implements ProfesorDAO {
	
	private static ProfesorDAOImplementacion instancia;
	private DataSource dataSource;
	
	private ProfesorDAOImplementacion(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public static ProfesorDAOImplementacion getInstance(DataSource datasource) {
		if(instancia== null) {
			instancia = new ProfesorDAOImplementacion(datasource);
		}
		return instancia;
	}

	@Override
	public void crearProfesor(ProfesorEntidad profesor) {
		String sql = "insert into profesor (codProfesor, nombreProfesor, ciudad) values (?, ?, ?)";
		
		Connection connection;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, profesor.getCodProfesor());
			statement.setString(2, profesor.getNombreProfesor());
			statement.setString(3, profesor.getCiudad());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ProfesorEntidad obtenerProfesorPorId(String id) {
		String sql = "SELECT * FROM profesor WHERE cod_profesor = ?";
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				
				return mapearResultSetAProfesor(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public ProfesorEntidad obtenerProfesorPorNombre(String nombre) {
		String sql = "SELECT * FROM profesor WHERE nombre_profesor = ?";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nombre);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				return mapearResultSetAProfesor(result);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProfesorEntidad> obtenerTodosLosProfesores() {
		String sql = "SELECT cod_profesor, nombre_profesor, ciudad FROM profesor";
		List<ProfesorEntidad> profesores = new ArrayList<ProfesorEntidad>();
		
		try {
			Connection connection;
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				ProfesorEntidad profesor = mapearResultSetAProfesor(result);
				profesores.add(profesor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profesores;
	}

	@Override
	public void actualizarProfesor(ProfesorEntidad profesor) {
		String sql = "update profesor set nombre_profesor = ?, ciudad = ? where cod_profesor = ?";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, profesor.getNombreProfesor());
			statement.setString(2, profesor.getCiudad());
			statement.setString(3, profesor.getCodProfesor());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminarProfesor(String id) {
		String sql = "delete from profesor where cod_profesor = ?";
		
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
	
	@Override
	public List obetenerModulosPorProfesor(String codProfesor) {
		String sql = "select nombre_modulo from modulo where cod_profesor = ? ";
		List<String> modulos = new ArrayList<String>();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, codProfesor);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				modulos.add(result.getString(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modulos;
	}
	
	private ProfesorEntidad mapearResultSetAProfesor(ResultSet resultSet) throws SQLException {
		 ProfesorEntidad profesor = new ProfesorEntidad();
		 profesor.setCodProfesor(resultSet.getString("cod_profesor"));
		 profesor.setNombreProfesor(resultSet.getString("nombre_profesor"));
		 profesor.setCiudad(resultSet.getString("ciudad"));
		 return profesor;
		 }

	

	

}
