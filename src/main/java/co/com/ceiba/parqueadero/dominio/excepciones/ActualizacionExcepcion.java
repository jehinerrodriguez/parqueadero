package co.com.ceiba.parqueadero.dominio.excepciones;

public class ActualizacionExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ActualizacionExcepcion(String mensajeExcepcion) {
        super(mensajeExcepcion);
    }
}
