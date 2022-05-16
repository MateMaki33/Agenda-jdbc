package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;

public class AccesoDatosImp implements IAccesoDatos {

	Conexion conexion = new Conexion();
	private Connection cn = null;
	private Statement stm = null;
	private ResultSet rs = null;

	@Override
	public void agregarContacto() throws EscrituraDatosEx {
		String nombreContacto;
		String tfno;
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("Introduce nombre");
		System.out.println("--------------------------------");
		nombreContacto = sc.nextLine();
		System.out.println("--------------------------------");
		System.out.println("Introduce telefono");
		System.out.println("--------------------------------");
		tfno = sc.nextLine();

		String update = "INSERT INTO contactos (nombre, telefono) VALUES ('" + nombreContacto + "' ,'" + tfno + "' )";

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.executeUpdate(update);
			System.out.println("Se ha añadido un contacto nuevo");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				sc.close();
				if (cn != null) {
					cn.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public void borrarContacto() throws AccesoDatosEx {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("Que posicion quieres borrar");
		System.out.println("--------------------------------");
		int id = sc.nextInt()-1;
		String nombre=null;
		String update = "DELETE FROM `agenda`.`contactos` WHERE (`nombre` = '"+nombre+"')";
		int fila = 0;
		

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM contactos ORDER BY nombre");

			while (rs.next() && id != fila) {
				fila = rs.getRow();
				
				}
			
			if (id == fila) {
				String busqueda = rs.getNString(1);
				nombre = busqueda;
				update="DELETE FROM `agenda`.`contactos` WHERE (`nombre` = '"+nombre+"')";
			
			}
			
			stm.executeUpdate(update);
			System.out.println("Se ha borrado un contacto");
		

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				if (cn != null) {
					cn.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public void mostrarContactos() throws LecturaDatosEx {

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM contactos ORDER BY nombre");
			int indice=1;

			while (rs.next()) {
				String nombre = rs.getString(1);
				String telefono = rs.getString(2);
				System.out.println(indice+ " " + nombre + " " + telefono);
				indice++;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				if (cn != null) {
					cn.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
