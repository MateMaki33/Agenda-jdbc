package domain;

import java.util.Scanner;

import datos.AccesoDatosImp;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;

public class Agenda {

	public static void main(String[] args) {
	
		AccesoDatosImp obj = new AccesoDatosImp();
		Scanner sc = new Scanner(System.in);

		System.out.println("Que quieres hacer en la agenda");
		System.out.println("..............................................................");
		System.out.println("Introduce el numero correspondiente" + "\n1. Mostrar contactos" + "\n2. Agregar un contacto"
				+ "\n3. Borrar un contacto");

		int opc = sc.nextInt();

		switch (opc) {

		case 1:
			try {
				obj.mostrarContactos();
			} catch (LecturaDatosEx e) {
				System.out.println("No es posible mostrar los contactos");
				e.printStackTrace();
			}
			break;
		case 2:

			try {
				obj.agregarContacto();
			} catch (EscrituraDatosEx e) {
				System.out.println("No es posible agregar contactos");
				e.printStackTrace();
			}
			break;
		case 3:

			try {
				System.out.println("--------------------------------");
				System.out.println("Estos son los contactos");
				System.out.println("--------------------------------");
				obj.mostrarContactos();
				obj.borrarContacto();
			} catch (AccesoDatosEx e) {
				System.out.println("No es posible borrar contactos");
				e.printStackTrace();
			}
			break;

		default:

			System.out.println("opcion incorrecta");
		}

	}

}
