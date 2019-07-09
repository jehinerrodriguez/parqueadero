package co.com.ceiba.parqueadero.dominio.excepciones;

public class ExistenciaVehiculoExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExistenciaVehiculoExcepcion(String mensajeExcepcion) {
        super(mensajeExcepcion);
    }
}
