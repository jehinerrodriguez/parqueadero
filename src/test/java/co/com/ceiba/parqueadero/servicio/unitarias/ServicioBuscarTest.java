package co.com.ceiba.parqueadero.servicio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.dominio.constantes.ConstantesVigilante;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.parqueadero.dominio.servicio.BuscarVehiculoParqueaderoServicio;
import co.com.ceiba.parqueadero.testdatabuilder.RegistroVehiculoTestDataBuilder;

public class ServicioBuscarTest {
	
	private RepositorioRegistroVehiculo parqueaderoRepositorio;

	@Before
	public void prepararDatos() {
		// arrange
		this.parqueaderoRepositorio = mock(RepositorioRegistroVehiculo.class);
	}

	@Test
	public void listarParqueadero() {
		//Arrange
        RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
                .tipoVehiculo(ConstantesVigilante.TIPO_CARRO);
        
        Vigilante parqueadero = parqueaderoDataBuilder.build();

        BuscarVehiculoParqueaderoServicio listarServicio = new BuscarVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(parqueadero);
        
        List<Vigilante> listaParqeuadero = listarServicio.buscar();
        assertNotNull(listaParqeuadero);
	}
	
	@Test
	public void listarParqueaderoVacio() {
		
		List<Vigilante> vacio = new ArrayList<>();
		//Arrange
		RegistroVehiculoTestDataBuilder parqueaderoDataBuilder = new RegistroVehiculoTestDataBuilder()
                .tipoVehiculo(ConstantesVigilante.TIPO_CARRO);
        
        Vigilante parqueadero = parqueaderoDataBuilder.build();

        BuscarVehiculoParqueaderoServicio listarServicio = new BuscarVehiculoParqueaderoServicio(parqueaderoRepositorio);
        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(null);
        
        List<Vigilante> listaParqeuadero = listarServicio.buscar();
        assertEquals(vacio,listaParqeuadero);
	}


}
