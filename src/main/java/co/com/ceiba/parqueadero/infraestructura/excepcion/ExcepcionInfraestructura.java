package co.com.ceiba.parqueadero.infraestructura.excepcion;

public class ExcepcionInfraestructura {
    private String nombre;
    private String mensajeExcepcion;

    public ExcepcionInfraestructura(String nombre, String mensajeExcepcion) {
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
