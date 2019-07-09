package co.com.ceiba.parqueadero.testdatabuilder;

import java.util.Date;

import co.com.ceiba.parqueadero.dominio.constantes.ConstantesVigilante;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;

public class RegistroVehiculoTestDataBuilder {
	
	private static final double VALOR = 50000;
	
	private Long id;
	private String placa;
	private String tipoVehiculo;
	private String cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double valor;
	
	
    public RegistroVehiculoTestDataBuilder(){
        this.id = 1L;
        this.placa = "ABC123";
        this.tipoVehiculo = ConstantesVigilante.TIPO_CARRO;        
        this.cilindraje = null;
        this.fechaIngreso = new  Date();
        this.fechaSalida = null;
        this.valor = VALOR;
    }
	
	public RegistroVehiculoTestDataBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public RegistroVehiculoTestDataBuilder tipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public RegistroVehiculoTestDataBuilder placa(String placa) {
        this.placa = placa;
        return this;
    }

    public RegistroVehiculoTestDataBuilder cilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public RegistroVehiculoTestDataBuilder fechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public RegistroVehiculoTestDataBuilder fechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }
    public RegistroVehiculoTestDataBuilder valor(long valor) {
        this.valor = valor;
        return this;
    }   

    public Vigilante build(){
    	return new Vigilante(id, placa, tipoVehiculo, cilindraje, fechaIngreso, fechaSalida, valor);
    }
}
