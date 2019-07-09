package co.com.ceiba.parqueadero.dominio.modelo.unitarias;

import org.junit.Test;

import co.com.ceiba.parqueadero.dominio.constantes.ConstantesVigilante;
import co.com.ceiba.parqueadero.dominio.excepciones.ValorRequeridoExcepcion;
import co.com.ceiba.parqueadero.dominio.excepciones.TipoVehiculoExcepcion;
import co.com.ceiba.parqueadero.dominio.testbase.TestBase;
import co.com.ceiba.parqueadero.testdatabuilder.RegistroVehiculoTestDataBuilder;

public class VigilanteTest {
	
	@Test
    public void placaObligatoriaTest() {
        //Arrange
        RegistroVehiculoTestDataBuilder parqueaderoTestDataBuilder = new RegistroVehiculoTestDataBuilder();

        parqueaderoTestDataBuilder.placa(null);

        //Act - Assert
        TestBase.assertThrows(() -> parqueaderoTestDataBuilder.build(), ValorRequeridoExcepcion.class, ConstantesVigilante.ERROR_PLACA_NULA);
    }

    @Test
    public void tipoVehiculoObligatorioTest() {
        //Arrange
    	RegistroVehiculoTestDataBuilder parqueaderoTestDataBuilder = new RegistroVehiculoTestDataBuilder();

    	parqueaderoTestDataBuilder.tipoVehiculo(null);

        //Act - Assert
        TestBase.assertThrows(() -> parqueaderoTestDataBuilder.build(), ValorRequeridoExcepcion.class, ConstantesVigilante.MENSAJE_TIPO_VEHICULO_NULO);
    }

    @Test
    public void tipoVehiculoTest() {
        //Arrange
    	RegistroVehiculoTestDataBuilder parqueaderoTestDataBuilder = new RegistroVehiculoTestDataBuilder();
        String tipoVehiculo = "CARR";
        parqueaderoTestDataBuilder.tipoVehiculo(tipoVehiculo);

        //Act - Assert
        TestBase.assertThrows(() -> parqueaderoTestDataBuilder.build(), TipoVehiculoExcepcion.class,ConstantesVigilante.MENSAJE_ERROR_TIPO_VEHICULO);
    }

    @Test
    public void validarCilindrajeTest() {
        //Arrange
    	RegistroVehiculoTestDataBuilder parqueaderoTestDataBuilder = new RegistroVehiculoTestDataBuilder();

    	parqueaderoTestDataBuilder.tipoVehiculo("MOTO");
    	parqueaderoTestDataBuilder.cilindraje(null);

        //Act - Assert
        TestBase.assertThrows(() -> parqueaderoTestDataBuilder.build(), ValorRequeridoExcepcion.class,ConstantesVigilante.MENSAJE_CILINDRAJE_NO_VALIDO);
    }
}
