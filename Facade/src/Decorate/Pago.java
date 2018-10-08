
package Decorate;

/**
 *
 * @author Danielpulido10
 */
public class Pago implements ComponenteD {
    
    public String valor;
	public String documentoConductor;
	public String documentoPasajero;
	

	
	public void establecerParametros(String parametros) {
		String[] parametrosBanco = parametros.split(",");
		setValor(parametrosBanco[0]);
		setDocumentoConductor(parametrosBanco[1]);
		setDocumentoPasajero(parametrosBanco[2]);
	}

	@Override
	public String obtenerParametros() {
		return "Valor: " + getValor() + ". Documento conductor: " + getDocumentoConductor()
		+ ". Documento pasajero: " + getDocumentoPasajero();
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDocumentoConductor() {
		return documentoConductor;
	}

	public void setDocumentoConductor(String documentoConductor) {
		this.documentoConductor = documentoConductor;
	}

	public String getDocumentoPasajero() {
		return documentoPasajero;
	}

	public void setDocumentoPasajero(String documentoPasajero) {
		this.documentoPasajero = documentoPasajero;
	}
    
}
