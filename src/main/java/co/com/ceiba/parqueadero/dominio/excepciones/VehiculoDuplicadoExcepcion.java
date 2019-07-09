package co.com.ceiba.parqueadero.dominio.excepciones;

public class VehiculoDuplicadoExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VehiculoDuplicadoExcepcion(String mensajeExcepcion) {
        super(mensajeExcepcion);
    }

}
