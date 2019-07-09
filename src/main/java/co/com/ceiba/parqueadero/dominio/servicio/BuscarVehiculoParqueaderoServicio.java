package co.com.ceiba.parqueadero.dominio.servicio;

import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;

public class BuscarVehiculoParqueaderoServicio {

private RepositorioRegistroVehiculo parqueaderoRepositorio;
	
	public BuscarVehiculoParqueaderoServicio(RepositorioRegistroVehiculo parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public List<Vigilante> buscar(){
        return this.parqueaderoRepositorio.mostrarVehiculos();
    }
}
