
package Decorate;

/**
 *
 * @author Danielpulido10
 */
public class PagoPSEBanco extends PagoPSE {
    
    private String numeroCuenta;
	private String passCuenta;

	public PagoPSEBanco(ComponenteD pagoEspecial) {
		super(pagoEspecial);
	}

	
	
	public void establecerParametros(String parametros) {
		pagoEspecial.establecerParametros(parametros);
		String[] parametrosBanco = parametros.split(",");
		setNumeroCuenta(parametrosBanco[3]);
		setPassCuenta(parametrosBanco[4]);
		super.establecerParametros(parametrosBanco[5]);
	}
	
	@Override
	public String obtenerParametros() {
		return super.obtenerParametros() +". Número de cuenta: " + getNumeroCuenta() + ". Contraseña de cuenta:" +getPassCuenta();
	}


	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	public void setPassCuenta(String passCuenta) {
		this.passCuenta = passCuenta;
	}


	public String getNumeroCuenta() {
		return numeroCuenta;
	}


	public String getPassCuenta() {
		return passCuenta;
	}
	
    
}
