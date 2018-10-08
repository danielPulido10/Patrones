
package Singleton;

import facade.Facade;
import javax.swing.JOptionPane;
import proxy.Proxy;


public class Client {

    
    public static void main(String[] args) {
       
        String nombre;
		String correo;
		String contrasena;
		String documento;
		int opcion = 0;

		Facade facade = new Facade();
                Proxy proxy = new Proxy();
		//LLenado de arreglos
		facade.usuariosDummy();
		facade.rutasDummy();
		facade.reservasDummy();
                ProxySingleton ps = ProxySingleton.reemplazarConstructora();

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"" + "Seleccione la opción: \n" + "1. Registrar usuario \n" + "2. Acceder al sistema \n"
							+  "0. Salir"));
			switch (opcion) {
			case 1:
				int opcion1 = Integer.parseInt(JOptionPane.showInputDialog(
						"" + "1. Pasajero \n" + "2. Conductor \n" + "3. Administrador \n" + "4. Regresar"));
				switch (opcion1) {
				case 1:
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contraseña");
					documento = JOptionPane.showInputDialog("Introducir documento");
					facade.registrarPasajero(nombre, documento, correo, contrasena);
					break;
				case 2:
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contraseña");
					documento = JOptionPane.showInputDialog("Introducir documento");
					facade.registrarConductor(nombre, documento, correo, contrasena);
					break;
				case 3:
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contraseña");
					documento =JOptionPane.showInputDialog("Introducir documento");
					facade.registrarAdministrador(nombre, documento, correo, contrasena);
					break;
				case 4:
				}
				break;
			
			case 2:
				correo = JOptionPane.showInputDialog("Introducir correo");
				contrasena = JOptionPane.showInputDialog("Introducir contrasena");
                                JOptionPane.showMessageDialog(null, ""+ ps.unicaInstancia(correo, contrasena));
				break;
			}
		} while (opcion != 0);

	}
       
    }
    

