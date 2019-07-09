package co.com.ceiba.parqueadero.dominio.excepciones;

public class ValidarCupoExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidarCupoExcepcion(String mensajeExcepcion) {
		super(mensajeExcepcion);
	}
}
