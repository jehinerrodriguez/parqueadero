package co.com.ceiba.parqueadero.infraestructura.excepcion;

public class ExcepcionInfraestructura extends RuntimeException {
    
	private static final long serialVersionUID = 1L;
	private String nombre;
    private String mensajeExcepcion;

    public ExcepcionInfraestructura(String nombre, String mensajeExcepcion) {
    	super();
        this.nombre = nombre;
        this.mensajeExcepcion = mensajeExcepcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMensajeExcepcion() {
        return mensajeExcepcion;
    }
}
