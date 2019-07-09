package co.com.ceiba.parqueadero.dominio.modelo;

import co.com.ceiba.parqueadero.dominio.constantes.ConstantesVigilante;
import co.com.ceiba.parqueadero.dominio.excepciones.ValorRequeridoExcepcion;
import co.com.ceiba.parqueadero.dominio.excepciones.TipoVehiculoExcepcion;

public final class ValidarVigilante {

	private ValidarVigilante() {
	}
    
    public static void validarDatoObligatorio(Object valorIngresado, String mensajeExcepcion){
        if(valorIngresado == null || valorIngresado.equals("")) {
            throw new ValorRequeridoExcepcion(mensajeExcepcion);
        }
    }
    
    public static void validarTipoVehiculo(Object valorIngresado, String mensajeExcepcion) {
	    if(!valorIngresado.equals(ConstantesVigilante.TIPO_CARRO) && !valorIngresado.equals(ConstantesVigilante.TIPO_MOTO)) {
	        throw new TipoVehiculoExcepcion(mensajeExcepcion);
	    }
    }
}
