package co.com.ceiba.parqueadero.dominio.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;

public interface RepositorioRegistroVehiculo {	
	
	public Vigilante crearVehiculo(Vigilante parqueadero);
	public int cuposPorTipoVehiculo(String tipoVehiculo);
	public boolean existeVehiculo(String placa);
	public List<Vigilante> mostrarVehiculos();
	public Vigilante buscarVehiculo(String placa);
}
