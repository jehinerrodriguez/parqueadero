package co.com.ceiba.parqueadero.dominio.excepciones;

public class ValorRequeridoExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValorRequeridoExcepcion(String mensajeExcepcion) {
        super(mensajeExcepcion);
    }
}

