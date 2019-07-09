package co.com.ceiba.parqueadero.testdatabuilder;

import java.util.Date;

import co.com.ceiba.parqueadero.aplicacion.comando.ParqueaderoComando;

public class ParqueaderoComandoTestDataBuilder {

	private Long id;
	private String placa;
	private String tipoVehiculo;
	private String cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double total;

    public ParqueaderoComandoTestDataBuilder(){
        this.id = 1L;
        this.placa = "DXR423";
        this.tipoVehiculo = "CARRO";
        this.cilindraje = null;
        this.fechaIngreso = new Date();
        this.fechaSalida = null;
        this.total = 0;
    }

    public ParqueaderoComandoTestDataBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ParqueaderoComandoTestDataBuilder tipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public ParqueaderoComandoTestDataBuilder placa(String placa) {
        this.placa = placa;
        return this;
    }

    public ParqueaderoComandoTestDataBuilder cilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public ParqueaderoComandoTestDataBuilder fechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public ParqueaderoComandoTestDataBuilder fechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }
    public ParqueaderoComandoTestDataBuilder total(double total) {
        this.total = total;
        return this;
    }

    public ParqueaderoComando build(){
        return new ParqueaderoComando(placa,tipoVehiculo,cilindraje);
    }
}
