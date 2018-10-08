
package proxy;

import adapter.Usuario;
import facade.Facade;
import javax.swing.JOptionPane;

/**
 *
 * @author Danielpulido10
 */
public class Proxy{
    
    
    Facade facade = new Facade();
    Usuario us;
    
    public String  operacion(String correo, String clave){
     
        int verUsuario = facade.verificarUsuario(correo, clave);
        if (verUsuario == 0) {
            JOptionPane.showMessageDialog(null, "El usuario no existe");
        } else if(verUsuario == 1 ){
            return facade.MenuPasajero();
        }else if(verUsuario == 2){
            return facade.MenuConductor();
        }
        
        return "";
    }

    
}
