package co.com.ceiba.parqueadero.aplicacion.comando.manejador;

import co.com.ceiba.parqueadero.dominio.servicio.ActualizarSalidaVehiculoParqueaderoServicio;

public class RetiroVehiculoManejador {
	
	private final ActualizarSalidaVehiculoParqueaderoServicio actualizarServicio;

    public RetiroVehiculoManejador(ActualizarSalidaVehiculoParqueaderoServicio servicio){
        this.actualizarServicio = servicio;
    }

    public double actualizar(String placa){
        return this.actualizarServicio.actualizar(placa);
    }

}
