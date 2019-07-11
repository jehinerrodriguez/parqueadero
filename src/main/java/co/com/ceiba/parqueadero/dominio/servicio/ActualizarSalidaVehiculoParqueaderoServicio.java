package co.com.ceiba.parqueadero.dominio.servicio;

import java.util.Calendar;

import co.com.ceiba.parqueadero.dominio.constantes.ConstantesVigilante;
import co.com.ceiba.parqueadero.dominio.excepciones.ExistenciaVehiculoExcepcion;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.modelo.ValidarVigilante;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;

public class ActualizarSalidaVehiculoParqueaderoServicio {
	
	public static final long MILISEGUNDOS_HORA = 3600000;
	public static final long MILISEGUNDOS_DIA = 86400000;
	
	public static final int PRECIO_MOTO_DIA = 4000;
	public static final int PRECIO_CARRO_DIA = 8000;
	public static final int PRECIO_MOTO_HORA = 500;
	public static final int PRECIO_CARRO_HORA = 1000;
	public static final int PRECIO_ADICIONAL = 2000;


	private RepositorioRegistroVehiculo parqueaderoRepositorio;
	
	public ActualizarSalidaVehiculoParqueaderoServicio(RepositorioRegistroVehiculo parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public double actualizar(String placa){
		ValidarVigilante.validarDatos(placa, ConstantesVigilante.ERROR_PLACA_NULA);
		Vigilante parqueadero = validarRegistro(placa);
		parqueadero.setFechaSalida(Calendar.getInstance().getTime());	
		calcularPrecio(parqueadero);
        this.parqueaderoRepositorio.crearVehiculo(parqueadero);
        return parqueadero.getTotal();
    }
	
	private Vigilante validarRegistro(String placa) {
		Vigilante parqueadero = this.parqueaderoRepositorio.buscarVehiculo(placa);
		if (parqueadero == null) {
			throw new ExistenciaVehiculoExcepcion(ConstantesVigilante.MENSAJE_NO_VEHICULO_EN_PARQUEADERO);
		}
		return parqueadero;
	}
	
	public void calcularPrecio(Vigilante vigilante) {
        double diferenciaMilisegundos = (vigilante.getFechaSalida().getTime() - vigilante.getFechaIngreso().getTime());
        long diferenciaDias = (long) (diferenciaMilisegundos / MILISEGUNDOS_DIA);
        diferenciaMilisegundos = (diferenciaMilisegundos - (MILISEGUNDOS_DIA * diferenciaDias));
		double diferenciaHoras = diferenciaMilisegundos / MILISEGUNDOS_HORA;
		String tipoVehiculo = vigilante.getTipoVehiculo();
		
		String cilindraje = vigilante.getCilindraje();
		
		if(cilindraje == null) 
			cilindraje = "0";
		
		Integer cilindrajeNumerico = Integer.parseInt(cilindraje);
		
		if (diferenciaHoras >= ConstantesVigilante.HORAS_MAXIMAS_HORA_POR_DIA) {
			diferenciaHoras = 0;
			diferenciaDias++;
		}
		
		diferenciaHoras = Math.ceil(diferenciaHoras);
		
		double precioFinal = tipoVehiculo.equals(ConstantesVigilante.TIPO_CARRO) ? diferenciaDias * PRECIO_CARRO_DIA + (diferenciaHoras * PRECIO_CARRO_HORA)
				: (diferenciaDias * PRECIO_MOTO_DIA) + (diferenciaHoras * PRECIO_MOTO_HORA);
		
		vigilante.setTotal((cilindrajeNumerico > ConstantesVigilante.CILINDRAJE_ALTO && tipoVehiculo.equals(ConstantesVigilante.TIPO_MOTO)) ? precioFinal + PRECIO_ADICIONAL : precioFinal);
    }	
}
