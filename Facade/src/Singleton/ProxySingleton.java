
package Singleton;

/**
 *
 * @author samue
 */
import proxy.*;
public class ProxySingleton {
    private static ProxySingleton unicaInstancia = null;


private  ProxySingleton(){


}

public static ProxySingleton reemplazarConstructora() {

if (unicaInstancia == null)

unicaInstancia = new ProxySingleton();

return unicaInstancia;

}

public String unicaInstancia(String correo, String contrasena){
    Proxy proxy = new Proxy();
    return proxy.operacion(correo, contrasena);
}



}



