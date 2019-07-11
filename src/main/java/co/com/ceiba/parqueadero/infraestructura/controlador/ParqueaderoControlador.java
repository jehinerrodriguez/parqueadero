package co.com.ceiba.parqueadero.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.aplicacion.comando.ParqueaderoComando;
import co.com.ceiba.parqueadero.aplicacion.comando.manejador.RegistroVehiculoManejador;
import co.com.ceiba.parqueadero.aplicacion.comando.manejador.RetiroVehiculoManejador;
import co.com.ceiba.parqueadero.aplicacion.consulta.ListaVehiculoHandler;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/parqueadero")
public class ParqueaderoControlador {

	private RegistroVehiculoManejador entradaVehiculoHandler;
	private RetiroVehiculoManejador retiroVehiculoManejador;
	private ListaVehiculoHandler listaVehiculoHandler;

	@Autowired
	public ParqueaderoControlador(RegistroVehiculoManejador entradaVehiculoHandler,
			RetiroVehiculoManejador salidaVehiculoHandler, ListaVehiculoHandler listaVehiculoHandler) {
		this.entradaVehiculoHandler = entradaVehiculoHandler;
		this.retiroVehiculoManejador = salidaVehiculoHandler;
		this.listaVehiculoHandler = listaVehiculoHandler;
	}

	@GetMapping
	@ApiOperation("listar")
	public List<Vigilante> listaVehiculos() {
		return this.listaVehiculoHandler.listaVehiculos();
	}

	@PostMapping
	@ApiOperation("crear")
	public ParqueaderoComando getEntrada(@RequestBody ParqueaderoComando parqueaderoComando) {
		this.entradaVehiculoHandler.crear(parqueaderoComando);
		return parqueaderoComando;
	}

	@PutMapping("/{placa}")
	@ApiOperation("salida")
	public double getSalida(@PathVariable("placa") String placa) {
		return this.retiroVehiculoManejador.actualizar(placa);
	}
}
