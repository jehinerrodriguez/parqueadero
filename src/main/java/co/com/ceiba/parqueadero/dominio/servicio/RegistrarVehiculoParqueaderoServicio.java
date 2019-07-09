package co.com.ceiba.parqueadero.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.parqueadero.dominio.constantes.ConstantesVigilante;
import co.com.ceiba.parqueadero.dominio.excepciones.*;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;

public class RegistrarVehiculoParqueaderoServicio {

	private RepositorioRegistroVehiculo parqueaderoRepositorio;
	
	public RegistrarVehiculoParqueaderoServicio(RepositorioRegistroVehiculo parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public Vigilante crear(Vigilante vigilante){
		validarRegistro(vigilante.getPlaca());
		validarCupo(vigilante.getTipoVehiculo());
		validarEntrada(vigilante.getPlaca(),vigilante.getFechaIngreso());
        return this.parqueaderoRepositorio.crearVehiculo(vigilante);
    }
	
	private void validarRegistro(String placa) {
        boolean existe = parqueaderoRepositorio.existeVehiculo(placa);
        if(existe) {
            throw new VehiculoDuplicadoExcepcion(ConstantesVigilante.MENSAJE_VEHICULO_EN_PARQUEADERO);
        }
    }
	
	private void validarCupo(String tipoVehiculo) {
		if(tipoVehiculo.equalsIgnoreCase(ConstantesVigilante.TIPO_MOTO) && 
		   parqueaderoRepositorio.cuposPorTipoVehiculo(tipoVehiculo) == ConstantesVigilante.CUPO_MAXIMO_MOTOS) {
			throw new ValidarCupoExcepcion(ConstantesVigilante.MENSAJE_NO_CUPO_DISPONIBLE);
		}
		if(tipoVehiculo.equalsIgnoreCase(ConstantesVigilante.TIPO_CARRO) && 
		   parqueaderoRepositorio.cuposPorTipoVehiculo(tipoVehiculo) == ConstantesVigilante.CUPO_MAXIMO_CARROS) {
			throw new ValidarCupoExcepcion(ConstantesVigilante.MENSAJE_NO_CUPO_DISPONIBLE);
		}
    }
	
	private void validarEntrada(String placa, Date fechaIngreso) {
		Calendar fechaActual = Calendar.getInstance();
		fechaActual.setTimeInMillis(fechaIngreso.getTime());
		int day = fechaActual.get(Calendar.DAY_OF_WEEK);
		if (placa.startsWith(ConstantesVigilante.INICIAL_NO_PERMITIDA) || placa.startsWith("a") && (day != Calendar.MONDAY || day != Calendar.SUNDAY)) {
			throw new PlacaExcepcion(ConstantesVigilante.MENSAJE_PLACA_NO_VALIDA);
		}
    }
}
