package co.com.ceiba.parqueadero.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.aplicacion.comando.ParqueaderoComando;
import co.com.ceiba.parqueadero.aplicacion.comando.manejador.EntradaVehiculoHandler;
import co.com.ceiba.parqueadero.aplicacion.comando.manejador.SalidaVehiculoHandler;
import co.com.ceiba.parqueadero.aplicacion.consulta.ListaVehiculoHandler;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parqueadero") 
public class ParqueaderoControlador {

	private EntradaVehiculoHandler entradaVehiculoHandler;
	private SalidaVehiculoHandler salidaVehiculoHandler;
	private ListaVehiculoHandler listaVehiculoHandler;
	
	@Autowired
    public ParqueaderoControlador(EntradaVehiculoHandler entradaVehiculoHandler, 
    		SalidaVehiculoHandler salidaVehiculoHandler, ListaVehiculoHandler listaVehiculoHandler){
        this.entradaVehiculoHandler = entradaVehiculoHandler;
        this.salidaVehiculoHandler = salidaVehiculoHandler;
        this.listaVehiculoHandler = listaVehiculoHandler;
    }
	
	@RequestMapping(method= RequestMethod.GET)
	@ApiOperation("listar")
    public List<Vigilante> listaVehiculos() {
        return this.listaVehiculoHandler.listaVehiculos();
    }

    @PostMapping
    @ApiOperation("crear")
    public void getEntrada(@RequestBody ParqueaderoComando parqueaderoComando) {
        this.entradaVehiculoHandler.crear(parqueaderoComando);
    }

    @PutMapping("/{placa}")
    @ApiOperation("salida")
    public void getSalida(@PathVariable("placa") String placa) {
        this.salidaVehiculoHandler.actualizar(placa);
    }
}
