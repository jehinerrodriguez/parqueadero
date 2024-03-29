package co.com.ceiba.parqueadero.aplicacion.comando.manejador;

import java.util.Date;

import co.com.ceiba.parqueadero.aplicacion.comando.ParqueaderoComando;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.servicio.RegistrarVehiculoParqueaderoServicio;

public class RegistroVehiculoManejador {

	private final RegistrarVehiculoParqueaderoServicio crearServicio;

	public RegistroVehiculoManejador(RegistrarVehiculoParqueaderoServicio servicio) {
		this.crearServicio = servicio;
	}

	public void crear(ParqueaderoComando parqueaderoComando) {
		this.crearServicio.crear(new Vigilante(parqueaderoComando.getId(), parqueaderoComando.getPlaca(),
				parqueaderoComando.getTipoVehiculo(), parqueaderoComando.getCilindraje(), new Date(),
				parqueaderoComando.getFechaSalida(), parqueaderoComando.getTotal()));
	}

}
