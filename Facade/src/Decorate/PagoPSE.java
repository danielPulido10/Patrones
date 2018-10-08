
package Decorate;

/**
 *
 * @author Danielpulido10
 */
public class PagoPSE implements ComponenteD{
    
    protected ComponenteD pagoEspecial;
	private boolean confirmacionPago;
	
	public PagoPSE(ComponenteD pagoEspecial) {
		this.pagoEspecial = pagoEspecial;
	}
	
	@Override
	public void establecerParametros(String parametros) {
		//pagoEspecial.establecerParametros(parametros);
		setConfirmacionPago(Boolean.parseBoolean(parametros));
	}
	
	@Override
	public String obtenerParametros() {
		return pagoEspecial.obtenerParametros() +". "+ this.confirmacionPago ;
	}

	public boolean isConfirmacionPago() {
		return confirmacionPago;
	}

	public void setConfirmacionPago(boolean confirmacionPago) {
		this.confirmacionPago = confirmacionPago;
	}
    
}
