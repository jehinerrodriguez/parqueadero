package co.com.ceiba.parqueadero.servicio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.dominio.constantes.ConstantesVigilante;
import co.com.ceiba.parqueadero.dominio.excepciones.ExistenciaVehiculoExcepcion;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.parqueadero.dominio.servicio.ActualizarSalidaVehiculoParqueaderoServicio;
import co.com.ceiba.parqueadero.testdatabuilder.RegistroVehiculoTestDataBuilder;;

public class ServicioActualizarParqueaderoTest {

	private RepositorioRegistroVehiculo parqueaderoRepositorio;

	@Before
	public void prepararDatos() {
		// arrange
		this.parqueaderoRepositorio = mock(RepositorioRegistroVehiculo.class);
	}

	@Test
	public void vehiculoNoParqueado() {

		// Arrange
		RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
				.tipoVehiculo(ConstantesVigilante.TIPO_CARRO);

		Vigilante parqueadero = parqueaderoDataBuilder.build();

		ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(
				parqueaderoRepositorio);

		when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(null);

		// Act

		try {
			salidaServicio.actualizar(parqueadero.getPlaca());
			fail();
		} catch (ExistenciaVehiculoExcepcion e) {
			// Assert
			assertEquals(ConstantesVigilante.MENSAJE_NO_VEHICULO_EN_PARQUEADERO, e.getMessage());
		}
	}

	@Test
	public void validarHoraMoto() {
		// Arrange
		double valorPorHora = 500;
		int hora = 7;
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(new Date());

		fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

		RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
				.tipoVehiculo(ConstantesVigilante.TIPO_MOTO).fechaIngreso(fecha.getTime()).cilindraje("200");

		Vigilante parqueadero = parqueaderoDataBuilder.build();

		ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(
				parqueaderoRepositorio);
		when(parqueaderoRepositorio.buscarVehiculo(parqueadero.getPlaca())).thenReturn(parqueadero);

		// Act
		salidaServicio.actualizar(parqueadero.getPlaca());

		// Assert
		assertEquals((valorPorHora * hora), parqueadero.getTotal(), 0);

	}

	@Test
	public void validarAdicionalMoto() {
		// Arrange
		double valorPorHora = 500;
		int hora = 7;
		int valorAdicional = 2000;

		Calendar fecha = Calendar.getInstance();
		fecha.setTime(new Date());

		fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

		RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
				.tipoVehiculo(ConstantesVigilante.TIPO_MOTO).fechaIngreso(fecha.getTime()).cilindraje("600");

		Vigilante parqueadero = parqueaderoDataBuilder.build();

		ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(
				parqueaderoRepositorio);
		when(parqueaderoRepositorio.buscarVehiculo(parqueadero.getPlaca())).thenReturn(parqueadero);

		// Act
		salidaServicio.actualizar(parqueadero.getPlaca());

		// Assert
		assertEquals((valorPorHora * hora) + valorAdicional, parqueadero.getTotal(), 0);
	}

	@Test
	public void validarDiaCarro() {
		// Arrange
		double valorDia = 8000;
		int hora = 9;
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(new Date());

		fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

		RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
				.tipoVehiculo(ConstantesVigilante.TIPO_CARRO).fechaIngreso(fecha.getTime());

		Vigilante parqueadero = parqueaderoDataBuilder.build();

		ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(
				parqueaderoRepositorio);
		when(parqueaderoRepositorio.buscarVehiculo(parqueadero.getPlaca())).thenReturn(parqueadero);

		// Act
		salidaServicio.actualizar(parqueadero.getPlaca());

		// Assert
		assertEquals(valorDia, parqueadero.getTotal(), 0);

	}

	@Test
	public void validarDiaMotoCilindraje() {
		// Arrange
		double valorDia = 4000;
		int hora = 9;
		int valorAdicional = 2000;

		Calendar fecha = Calendar.getInstance();
		fecha.setTime(new Date());

		fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

		RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
				.tipoVehiculo(ConstantesVigilante.TIPO_MOTO).cilindraje("650").fechaIngreso(fecha.getTime());

		Vigilante parqueadero = parqueaderoDataBuilder.build();

		ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(
				parqueaderoRepositorio);
		when(parqueaderoRepositorio.buscarVehiculo(parqueadero.getPlaca())).thenReturn(parqueadero);

		// Act
		salidaServicio.actualizar(parqueadero.getPlaca());

		// Assert
		assertEquals(valorDia + valorAdicional, parqueadero.getTotal(), 0);

	}

	@Test
	public void validarDiaMoto() {
		// Arrange
		double valorDia = 4000;
		int hora = 9;

		Calendar fecha = Calendar.getInstance();
		fecha.setTime(new Date());

		fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

		RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
				.tipoVehiculo(ConstantesVigilante.TIPO_MOTO).cilindraje("200").fechaIngreso(fecha.getTime());

		Vigilante parqueadero = parqueaderoDataBuilder.build();

		ActualizarSalidaVehiculoParqueaderoServicio salidaServicio = new ActualizarSalidaVehiculoParqueaderoServicio(
				parqueaderoRepositorio);
		when(parqueaderoRepositorio.buscarVehiculo(parqueadero.getPlaca())).thenReturn(parqueadero);

		// Act
		salidaServicio.actualizar(parqueadero.getPlaca());

		// Assert
		assertEquals(valorDia, parqueadero.getTotal(), 0);

	}
}
