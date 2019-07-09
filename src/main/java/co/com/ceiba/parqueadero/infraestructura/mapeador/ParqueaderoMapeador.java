package co.com.ceiba.parqueadero.infraestructura.mapeador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.infraestructura.adaptador.entidad.ParqueaderoEntidad;

@Component
public class ParqueaderoMapeador {

	public Vigilante convertirADominio(ParqueaderoEntidad parqueaderoEntidad) {
		Vigilante parqueadero;

		if (parqueaderoEntidad == null) {
			parqueadero = null;
		} else {
			parqueadero = new Vigilante(parqueaderoEntidad.getId(), parqueaderoEntidad.getPlaca(),
					parqueaderoEntidad.getTipoVehiculo(), parqueaderoEntidad.getCilindraje(),
					parqueaderoEntidad.getFechaIngreso(), parqueaderoEntidad.getFechaSalida(),
					parqueaderoEntidad.getValorTotal());
		}

		return parqueadero;
	}

	public ParqueaderoEntidad convertirAEntidad(Vigilante parqueadero) {
		ParqueaderoEntidad parqueaderoEntidad;
		if (parqueadero == null) {
			parqueaderoEntidad = null;
		} else {
			parqueaderoEntidad = new ParqueaderoEntidad(parqueadero.getId(), parqueadero.getPlaca(),
					parqueadero.getTipoVehiculo(), parqueadero.getCilindraje(), parqueadero.getFechaIngreso(),
					parqueadero.getFechaSalida(), parqueadero.getTotal());
		}

		return parqueaderoEntidad;
	}

	public List<Vigilante> listaConvertirADominio(List<ParqueaderoEntidad> listaParqueaderoEntidad) {
		final List<Vigilante> listParqueadero = new ArrayList<>();

		listaParqueaderoEntidad
				.forEach(parqueaderoEntidad -> listParqueadero.add(new Vigilante(parqueaderoEntidad.getId(),
						parqueaderoEntidad.getPlaca(), parqueaderoEntidad.getTipoVehiculo(),
						parqueaderoEntidad.getCilindraje(), parqueaderoEntidad.getFechaIngreso(),
						parqueaderoEntidad.getFechaSalida(), parqueaderoEntidad.getValorTotal())));

		return listParqueadero;
	}

}
