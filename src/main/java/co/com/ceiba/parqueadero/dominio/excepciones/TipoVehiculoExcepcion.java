package co.com.ceiba.parqueadero.dominio.excepciones;

public class TipoVehiculoExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TipoVehiculoExcepcion(String mensajeExcepcion) {
        super(mensajeExcepcion);
    }
}
