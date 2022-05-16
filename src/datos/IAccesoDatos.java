package datos;

import excepciones.*;

public interface IAccesoDatos {
	
   void agregarContacto() throws EscrituraDatosEx;
   
   void borrarContacto() throws AccesoDatosEx;
   
   void mostrarContactos() throws LecturaDatosEx;
}
