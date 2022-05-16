package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/agenda";
	private static final String USUARIO = "root";
	private static final String CLAVE = "041063daw";

	static {
		try {
			Class.forName(CONTROLADOR);

		} catch (ClassNotFoundException e) {
			System.out.println("Error de controlador");
			e.printStackTrace();
		}
	}

	public Connection conectar() {
		Connection conexion = null;
		try {

			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("--------------------------------");
			System.out.println("conexion ok");
			System.out.println("--------------------------------");

		} catch (SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();

		}

		return conexion;
	}

}

