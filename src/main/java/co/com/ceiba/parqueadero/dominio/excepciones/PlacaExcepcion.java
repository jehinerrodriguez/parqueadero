package co.com.ceiba.parqueadero.dominio.excepciones;

public class PlacaExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlacaExcepcion(String mensajeExcepcion) {
		super(mensajeExcepcion);
	}
}
