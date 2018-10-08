
package FlyWeight;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import adapter.Usuario;
import facade.*;
/**
 *
 * @author Danielpulido10
 */
public class FlyWeightFactory {
    
    private HashMap usBasicInf = new HashMap();
	
	public FlyWeightFactory() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	public void eliminarUs(String documento)
	{
		usBasicInf.remove(documento);
	}
	
	public IFlyWeight obtenerUsuario(String documento)
	{
		IFlyWeight us =(IFlyWeight)usBasicInf.get(documento);
		
		return us;
	}
	
	public void cargarUsuarios() {
		

	}
	

	public void añadirUsuario(IFlyWeight usEspe)
	{
		
		if(!usBasicInf.containsKey(usEspe.getDocumento()))
		{
			usBasicInf.put(usEspe.getDocumento(), usEspe);
		}else
		{
			JOptionPane.showMessageDialog(null,  "El usuario ya existe");
		}
		
	}
	
	public String mostrarUsuarios()
	{
		String cadena = "";
		Iterator iterator = usBasicInf.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry pair = (Map.Entry)iterator.next();
			cadena += pair.getKey().toString() +" = "+ ((IFlyWeight)pair.getValue()).getNombre() +"\n";
		}
		return	cadena;
	}
    
}
