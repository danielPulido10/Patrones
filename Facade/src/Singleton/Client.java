
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
                                String a = JOptionPane.showInputDialog(null, ""+ ps.unicaInstancia(correo, contrasena));
                                int b =  Integer.parseInt(a);
                                switch(b){
                                    case 1:
                                        String nombrereserva =JOptionPane.showInputDialog("Nombre de reserva");
                                        String nombrerutar = JOptionPane.showInputDialog("Nombre de ruta reservada");
                                        String puestoruta =JOptionPane.showInputDialog("Puesto de la ruta");
                                        int puestorutan = Integer.parseInt(puestoruta);
                                        String documentop= JOptionPane.showInputDialog("Documento de pasajero");
                                        
                                        facade.crearRegistroReserva(nombrereserva, nombrerutar, puestorutan, documentop);
                                        
                                        break;
                                        
                                    case 2:
                                        System.out.print("Hola");
                                        String documentopa= JOptionPane.showInputDialog("Documento");
                                        
                                        int veri = facade.verificarUsuario(correo, contrasena);
                                        
                                        if (veri ==1){
                                            
                                            //PASAJERO
                                            
                                            facade.listarReservasPasajero(documentopa);
                                        }else {
                                            if(veri ==2){
                                                //CONDUCTOR
                                                
                                               facade.listarRutasConductor(documentopa);
                                            } else{
                                                    if (veri ==0){
                                                     JOptionPane.showMessageDialog(null, "No hay listas que mostrar");
                                                    }
                                                  }  
                                               }
                                        break;
                                        
                                    case 3:
                                        String nombrereservam =JOptionPane.showInputDialog("Nombre de reserva");
                                        String nombrerutarm = JOptionPane.showInputDialog("Nombre de ruta reservada");
                                        String puestorutam =JOptionPane.showInputDialog("Puesto de la ruta");
                                        int puestorutanm = Integer.parseInt(puestorutam);
                                        String documentopm= JOptionPane.showInputDialog("Documento de pasajero");
                                        int veri2 = facade.verificarUsuario(correo, contrasena);
                                        
                                        if (veri2 ==1){
                                            
                                            //PASAJERO
                                            
                                           facade.modificarReservaPasajero(nombrereservam, nombrereservam, puestorutanm, documentopm);
                                        }else {
                                            if(veri2 ==2){
                                                //CONDUCTOR
                                                
                                               JOptionPane.showMessageDialog(null, "No hay reservas que modificar");
                                            } else{
                                                    if (veri2 ==0){
                                                     JOptionPane.showMessageDialog(null, "No hay reservas que modificar");
                                                    }
                                                  }  
                                               }
                                        
                                       break;
                                       
                                    case 4:
                                        String nombrereservae =JOptionPane.showInputDialog("Nombre de reserva");
                                        String documentope= JOptionPane.showInputDialog("Documento de pasajero");
                                        
                                       facade.eliminarReserva(nombrereservae, documentope);
                                      }  
				break;
			}
		} while (opcion != 0);

	}
       
    }
    

