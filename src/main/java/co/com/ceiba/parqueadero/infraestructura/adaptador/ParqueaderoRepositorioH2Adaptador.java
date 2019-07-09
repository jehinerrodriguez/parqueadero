package co.com.ceiba.parqueadero.infraestructura.adaptador;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.parqueadero.infraestructura.adaptador.entidad.ParqueaderoEntidad;
import co.com.ceiba.parqueadero.infraestructura.mapeador.ParqueaderoMapeador;
import co.com.ceiba.parqueadero.infraestructura.adaptador.repositorio.ParqueaderoRepositorioJPA;

@Repository
public class ParqueaderoRepositorioH2Adaptador implements RepositorioRegistroVehiculo{

	private ParqueaderoRepositorioJPA parqueaderoRepositorioJPA;
	private ParqueaderoMapeador mapeador;
	
	public ParqueaderoRepositorioH2Adaptador(ParqueaderoRepositorioJPA parqueaderoRepositorioJPA, ParqueaderoMapeador mapeador){
        this.parqueaderoRepositorioJPA = parqueaderoRepositorioJPA;
        this.mapeador = mapeador;
    }
	    
	@Override
	public Vigilante crearVehiculo(Vigilante parqueadero) {
		ParqueaderoEntidad parqueaderoEntidad = parqueaderoRepositorioJPA.save(mapeador.convertirAEntidad(parqueadero));
		return mapeador.convertirADominio(parqueaderoEntidad);
	}


	@Override
	public int cuposPorTipoVehiculo(String tipoVehiculo) {
		return parqueaderoRepositorioJPA.vehiculosPorTipo(tipoVehiculo);
	}

	@Override
	public boolean existeVehiculo(String placa) {
		return parqueaderoRepositorioJPA.validarPlacaIngresada(placa);
	}

	@Override
	public List<Vigilante> mostrarVehiculos() {
		List<ParqueaderoEntidad> listaParqueaderoEntidad = parqueaderoRepositorioJPA.buscarRegistroVehiculos();
		return mapeador.listaConvertirADominio(listaParqueaderoEntidad);
	}

	@Override
	public Vigilante buscarVehiculo(String placa) {
		ParqueaderoEntidad parqueaderoEntidad = parqueaderoRepositorioJPA.buscarPorPlaca(placa);
		return mapeador.convertirADominio(parqueaderoEntidad);
	}

}
