package co.com.ceiba.parqueadero.servicio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.dominio.constantes.ConstantesVigilante;
import co.com.ceiba.parqueadero.dominio.excepciones.PlacaExcepcion;
import co.com.ceiba.parqueadero.dominio.excepciones.ValidarCupoExcepcion;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.parqueadero.dominio.servicio.RegistrarVehiculoParqueaderoServicio;
import co.com.ceiba.parqueadero.testdatabuilder.RegistroVehiculoTestDataBuilder;

public class ServicioCrearParqueaderoTest {
	
	private RepositorioRegistroVehiculo parqueaderoRepositorio;

	@Before
	public void prepararDatos() {
		// arrange
		this.parqueaderoRepositorio = mock(RepositorioRegistroVehiculo.class);
	}
	
	@Test
	public void crearParqueoMotoTest() {
		//Arrange
		RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
				.placa(ConstantesVigilante.PLACA_WSD123)
                .tipoVehiculo(ConstantesVigilante.TIPO_MOTO)
                .cilindraje("600");

        Vigilante parqueadero = parqueaderoDataBuilder.build();

        RegistrarVehiculoParqueaderoServicio crearServicio = new RegistrarVehiculoParqueaderoServicio(parqueaderoRepositorio);

        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(parqueadero);

        //Act
        Vigilante parqueaderoCopia =  crearServicio.crear(parqueadero);

        //Assert
        assertEquals(parqueaderoCopia.getId(),parqueadero.getId());
	}
	
	@Test
    public void validarPlacaTest(){
        //Arrange
        Calendar fechaIngreso = Calendar.getInstance();
        fechaIngreso.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder().placa("ADF123")
                .tipoVehiculo(ConstantesVigilante.TIPO_CARRO).fechaIngreso(fechaIngreso.getTime());
        Vigilante parqueadero = parqueaderoDataBuilder.build();

        RegistrarVehiculoParqueaderoServicio crearServicio = new RegistrarVehiculoParqueaderoServicio(parqueaderoRepositorio);
        //Act
        try {
        	crearServicio.crear(parqueadero);
            fail();
        }catch (PlacaExcepcion e){
            // Assert
            assertEquals(ConstantesVigilante.INICIAL_NO_PERMITIDA, e.getMessage());
        }
    }
	
	@Test
	public void crearParqueoCarroTest() {
		//Arrange
		RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
				.placa(ConstantesVigilante.PLACA_WSD123)
                .tipoVehiculo(ConstantesVigilante.TIPO_CARRO);

        Vigilante parqueadero = parqueaderoDataBuilder.build();

        RegistrarVehiculoParqueaderoServicio crearServicio = new RegistrarVehiculoParqueaderoServicio(parqueaderoRepositorio);

        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(parqueadero);

        //Act
        Vigilante parqueaderoCopia =  crearServicio.crear(parqueadero);

        //Assert
        assertEquals(parqueaderoCopia.getId(),parqueadero.getId());
	}
	
	@Test
	public void validarCupoMotoTest() {
		//Arrange
		RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
				.placa(ConstantesVigilante.PLACA_WSD123)
                .tipoVehiculo(ConstantesVigilante.TIPO_MOTO)
                .cilindraje("600");

        Vigilante parqueadero = parqueaderoDataBuilder.build();

        RegistrarVehiculoParqueaderoServicio crearServicio = new RegistrarVehiculoParqueaderoServicio(parqueaderoRepositorio);

        when(parqueaderoRepositorio.cuposPorTipoVehiculo(ConstantesVigilante.TIPO_MOTO)).thenReturn(ConstantesVigilante.CUPO_MAXIMO_MOTOS);

        //Act
        try {
        	crearServicio.crear(parqueadero);
            fail();
        }catch (ValidarCupoExcepcion e){
            // Assert
            assertEquals(ConstantesVigilante.MENSAJE_NO_CUPO_DISPONIBLE, e.getMessage());
        }
	}
	
	@Test
	public void validarCupoCarroTest() {
		//Arrange
		RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
				.placa(ConstantesVigilante.PLACA_WSD123)
                .tipoVehiculo(ConstantesVigilante.TIPO_CARRO);

        Vigilante parqueadero = parqueaderoDataBuilder.build();

        RegistrarVehiculoParqueaderoServicio crearServicio = new RegistrarVehiculoParqueaderoServicio(parqueaderoRepositorio);

        when(parqueaderoRepositorio.cuposPorTipoVehiculo(ConstantesVigilante.TIPO_CARRO)).thenReturn(ConstantesVigilante.CUPO_MAXIMO_CARROS);

        //Act
        try {
        	crearServicio.crear(parqueadero);
            fail();
        }catch (ValidarCupoExcepcion e){
            // Assert
            assertEquals(ConstantesVigilante.MENSAJE_NO_CUPO_DISPONIBLE, e.getMessage());
        }
	}
}
