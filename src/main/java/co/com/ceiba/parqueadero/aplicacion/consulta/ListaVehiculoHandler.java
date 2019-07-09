package co.com.ceiba.parqueadero.aplicacion.consulta;

import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.servicio.BuscarVehiculoParqueaderoServicio;

public class ListaVehiculoHandler {

	private final BuscarVehiculoParqueaderoServicio buscarServicio;

    public ListaVehiculoHandler(BuscarVehiculoParqueaderoServicio servicio){
        this.buscarServicio = servicio;
    }

    public List<Vigilante> listaVehiculos(){
        return this.buscarServicio.buscar();
    }
}
