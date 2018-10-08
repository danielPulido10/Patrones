/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

/**
 *
 * @author samue
 */
public class ProxySingleton {
    private static ProxySingleton unicaInstancia = null;


private  ProxySingleton(){


}

public static ProxySingleton reemplazarConstructora() {

if (unicaInstancia == null)

unicaInstancia = new ProxySingleton();

return unicaInstancia;

}

}



