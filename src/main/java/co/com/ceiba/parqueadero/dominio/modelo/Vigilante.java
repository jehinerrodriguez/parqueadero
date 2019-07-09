package co.com.ceiba.parqueadero.dominio.modelo;

import java.util.Date;

import co.com.ceiba.parqueadero.dominio.constantes.ConstantesVigilante;

public class Vigilante {
	
	private Long id;
	private String placa;
	private String tipoVehiculo;
	private String cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double total;
	
	public Vigilante(Long id, String placa, String tipoVehiculo, String cilindraje, Date fechaIngreso, Date fechaSalida, double total) {
		ValidarVigilante.validarDatos(placa, ConstantesVigilante.ERROR_PLACA_NULA);
		ValidarVigilante.validarDatos(tipoVehiculo, ConstantesVigilante.MENSAJE_TIPO_VEHICULO_NULO);
		
		ValidarVigilante.validarTipoVehiculo(tipoVehiculo, ConstantesVigilante.MENSAJE_ERROR_TIPO_VEHICULO);
		
		if(tipoVehiculo.equalsIgnoreCase(ConstantesVigilante.TIPO_MOTO)) {
			ValidarVigilante.validarDatos(cilindraje, ConstantesVigilante.MENSAJE_CILINDRAJE_NO_VALIDO);
		}
		
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
