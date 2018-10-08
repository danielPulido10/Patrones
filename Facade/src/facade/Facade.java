
package facade;

import java.util.ArrayList;

import adapter.*;
import Composite.*;
import Decorate.Pago;
import Decorate.PagoPSEBanco;
import Decorate.PagoPSETarjeta;
import Decorate.ComponenteD;
import FlyWeight.FlyWeightFactory;
import FlyWeight.IFlyWeight;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import proxy.IProxy;

public class Facade implements IProxy{
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static ArrayList<Ruta> rutas = new ArrayList<Ruta>();
	private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        private static ArrayList<ComponenteD> pagos = new ArrayList<ComponenteD>();
        private  FlyWeightFactory fabricaUsers = new FlyWeightFactory();;
        public static Hashtable<Long, String> aleatorios = new Hashtable<Long, String>();
        private static Facade mFacade;
        
        public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
        
        private Facade() {
	}

	public static Facade getInstance() {
		if (mFacade == null) {
			mFacade = new Facade();
		}
		return mFacade;
	}


	
	public int verificarUsuario(String correo, String pass) {
		int tipoPasajero = 0;
		for (Usuario us : usuarios) {
			if (us.getCorreo().equals(correo) && us.getContrasena().equals(pass)) {
				
				return obtenerTipo(us);
			} 
		}
		return tipoPasajero;
	}

	private int obtenerTipo(Usuario us) {
		int tipoUsu = 0;
		if (us instanceof Pasajero) {
			tipoUsu = 1;
		} else if (us instanceof Conductor) {
			tipoUsu = 2;
		}
		return tipoUsu;
	}
		
	public Usuario obtenerUsuario(Long aleatorio) {
		String correo = aleatorios.get(aleatorio);
		for(Usuario us: usuarios) {
			if(us.getCorreo().equals(correo)) {
				return us;
			}
		}
		return null;
	}
	
	public String obtenerUsuarios() {
		String info = "";
		for(Usuario us: usuarios) {
			info += us.toString() + "\n";
		}
		return info;
	}

	public void crearRegistroRuta(String nombreRuta, ArrayList<Componente> calles, String documentoConductor) {
		Ruta ruta = new Ruta(nombreRuta, documentoConductor);
		ruta.setComponentes(calles);
		rutas.add(ruta);
	}

	
	public String listarRutasConductor(String documento) {
		String infoRutas = "No se encontraron las rutas para el documento "+ documento;
		String info = "";
		for(int i=0; i < rutas.size(); i++) {
			if(rutas.get(i).getDocumentoConductor().equals(documento)) {
				info += (i++) + rutas.get(i).obtenerDatos()+"\n\n";
			}
		}
		return (info.isEmpty() ? infoRutas: info);
	}

	public void actualizarRuta(String nombreRutaModificar, String nombreRutaNuevo, ArrayList<Componente> callesModificadas, String documentoConductor) {
		int position = 0;
		for(Ruta ru: rutas) {
			if(ru.getNombre().equals(nombreRutaModificar)) {
				Ruta rutaNueva = new Ruta(nombreRutaNuevo, documentoConductor);
				rutaNueva.setComponentes(callesModificadas);
				rutas.set(position, rutaNueva);
			}
			position++;
		}
	}

	public void eliminarRuta(String nombreRuta, String documentoConductor) {
		System.out.println("antes"+rutas.size());
		for(Ruta rut: rutas) {
			if(rut.getNombre().equals(nombreRuta) && rut.getDocumentoConductor().equals(documentoConductor)) {
				System.out.println(rut);
				rutas.remove(rut);
			}
		}
		System.out.println("Desoues"+rutas.size());
		
	}

	
	public void crearRegistroReserva(String nombreReserva, String nombreRutaReservada, int puestoRutaReservada, String documentoPasajero) {
		Reserva reserv = new Reserva(nombreReserva, puestoRutaReservada, nombreRutaReservada, documentoPasajero);
		reservas.add(reserv);
		System.out.println("Reserva añadida"+reserv.toString());
	}

	public String listarReservasPasajero(String documentoPasajero) {
		String lista = "";
		for(Reserva re: reservas) {
			if(re.getDocumentoPasajero().equals(documentoPasajero) ) {
				lista += "Nombre reserva: " + re.getNombreReserva() 
					+  "Nombre ruta reservada: " +re.getNombreRutaReservada()
					+ " \tPuesto reservado: " + re.getPuestoAReservar();
			}
		}
		return lista;
	}
	
	public String listarReservasPas(String documentoPasajero) {
		String lista = "No se encontraron reservas para el pasajero "+documentoPasajero;
		String infoRes = "";
		for(int i=0; i < reservas.size(); i++) {
			if(reservas.get(i).getDocumentoPasajero().equals(documentoPasajero)) {
				infoRes += (i++)+reservas.get(i).toString() + "\n";
			}
		}
		return (infoRes.isEmpty() ? lista: infoRes);
	}

	
	public void modificarReservaPasajero(String nombreReservaModificar, String nombreRutaReservadaModificado,
											int puestoRutaReservadaModificado, String documentoPasajero) {
		
		for(Reserva res: reservas) {
			
			if(res.getNombreReserva().equals(nombreReservaModificar) && res.getDocumentoPasajero().equals(documentoPasajero)) {
				System.out.println("Antes de modificar "+res.toString());
				res.setNombreRutaReservada((nombreRutaReservadaModificado.isEmpty() ? res.getNombreRutaReservada() : nombreRutaReservadaModificado));
				res.setPuestoAReservar(puestoRutaReservadaModificado);
				
				System.out.println("nueva"+ res.toString());
			}
		}
		
	}

	public void eliminarReserva(String nombreReservaEliminar, String documentoPasajero) {
		for(Reserva re: reservas) {
			if(re.getDocumentoPasajero().equals(documentoPasajero) && re.getNombreReserva() == nombreReservaEliminar) {
				reservas.remove(re);
				break;
			}
		}
	}

	public void registrarPasajero(String nombre, String documento, String correo, String contrasena) {
		Pasajero pasa = new Pasajero(nombre, correo, contrasena, documento);
		usuarios.add(pasa);
		fabricaUsers.añadirUsuario(pasa);
		
	}

	public void modificarPasajero(String nombre, String documento, String correo, String contrasena) {
		int position = 0;
		for(Usuario us: usuarios) {
			if(us.getDocumento().equals(documento)) {
				usuarios.set(position, new Pasajero(nombre, correo, contrasena, documento));
			}
			position++;
		}
	}

	public void eliminarUsuario(String documento) {
		for (Usuario us : usuarios) {
			if (us.getDocumento().equals(documento)) {
				System.out.println("Antes " + usuarios.size());
				usuarios.remove(us);
				fabricaUsers.eliminarUs(documento);
				System.out.println("Despues " + usuarios.size());
				break;
			}
		}
	}
	
	public void registrarConductor(String nombre, String documento, String correo, String contrasena) {
		Conductor cond = new Conductor(nombre, correo, contrasena, documento);
		fabricaUsers.añadirUsuario(cond);
		usuarios.add(cond);
		
	}

	public void modificarConductor(String nombre, String documento, String correo, String contrasena) {
		int position = 0;
		for(Usuario us: usuarios) {
			if(us.getDocumento().equals(documento)) {
				usuarios.set(position, new Conductor(nombre, correo, contrasena, documento));
			}
			position++;
		}
	}
	
	public void registrarAdministrador(String nombre, String documento, String correo, String contrasena) {
		AdministradorAdapter admin = new AdministradorAdapter(nombre, correo, contrasena, documento);
		fabricaUsers.añadirUsuario(admin);
		usuarios.add(admin);
	}

	public void modificarAdministrador(String nombre, String documento, String correo, String contrasena) {
		int position = 0;
		for(Usuario us: usuarios) {
			if(us.getDocumento().equals(documento)) {
				usuarios.set(position, new AdministradorAdapter(nombre, correo, contrasena, documento));
			}
			position++;
		}
	}
        public void registrarPago(String parametros) {
		ComponenteD component = new PagoPSEBanco(new Pago());
		component.establecerParametros(parametros);
		pagos.add(component);
	}

	public void registrarPagoTarjeta(String parametros) {
		ComponenteD component = new PagoPSETarjeta(new Pago());
		component.establecerParametros(parametros);
		pagos.add(component);
	}

	public String obtenerPagos() {
		String valoresPagos = "";
		for (ComponenteD pago : pagos) {
			valoresPagos += pago.obtenerParametros() + "\n";
		}
		return valoresPagos;
	}
	
	public void usuariosDummy() {
		usuarios.add(new Conductor("Jario lopez", "jairolo@unisabana.edu.co", "jario123", "1073525507"));
		usuarios.add(new Conductor("Sara Bustos", "sarabu@unisabana.edu.co", "sara123", "1045676829"));
		usuarios.add(new Pasajero("Ana Garcia", "anaga@unisabana.edu.co", "ana123", "1234567889"));
		usuarios.add(new Pasajero("Juan Correa", "juanco@unisabana.edu.co", "juan123", "216654382"));
		usuarios.add(new AdministradorAdapter("Jaime Contreras", "jaimeco@unisabana.edu.co", "jaime123", "106435678"));
	}
	
	public void rutasDummy() {
		Componente c1 = new Calle("12.09.54", "14.23.64", "34.13.74", "345.26.42.5", "Calle 9", "9 mts");
        Componente c2 = new Calle("34.25.1", "64.26.32.6", "32.75.47", "36.32.1345", "Calle 57", "14 mts");
        Componente c3 = new Calle("52.63.7.2", "54.2.67.2", "3245.2.6.3", "32.1.5.3", "Calle 91", "16 mts");
        
      
        Ruta ruta1 = new Ruta("Ruta 1","1073525507");
        Ruta ruta2 = new Ruta("Ruta 2","1073525507");
        Ruta ruta3 = new Ruta("Ruta 3","1045676829");
      
        ruta1.add(c1);
        ruta2.add(c2);
        ruta3.add(c3);
        
        rutas.add(ruta1);
        rutas.add(ruta2);
        rutas.add(ruta3);
	}
	
	public void reservasDummy() {
		
		reservas.add(new Reserva("Reserva 124738", 1, "Ruta 1", "1234567889"));
		
		reservas.add(new Reserva("Reserva 5243446",3, "Ruta 3", "216654382"));
	}
        
    public String MenuPasajero() {

        int opcion = 0;

        return "" + "1. Crear registro de reserva \n" + "2. Listar reservas \n"
                        + "3. Modificar reserva \n" + "4. Eliminar reserva \n" + "0. salir \n";
        
    }
    
    public String MenuConductor(){
        
        
        //int opcion = 0;
        return "" + "1. Crear ruta \n" + "2. Listar rutas \n"
							+ "3. Modificar ruta \n" + "4. Eliminar ruta \n" + "0. Salir \n";
					
        
    }

    @Override
	public Long Operacion(String correo, String password) {
		Long aleatorio = Long.parseLong(String.valueOf(Math.random() * 2E13 + 1));
		aleatorios.put(aleatorio, correo);
		return aleatorio;
	}

	public boolean isSession(Long keyLogin) {
		return aleatorios.contains(keyLogin) && keyLogin != 0 ? true : false;
	}


}
