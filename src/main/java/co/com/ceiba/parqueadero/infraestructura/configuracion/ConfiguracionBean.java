package co.com.ceiba.parqueadero.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.parqueadero.aplicacion.comando.manejador.EntradaVehiculoHandler;
import co.com.ceiba.parqueadero.aplicacion.comando.manejador.SalidaVehiculoHandler;
import co.com.ceiba.parqueadero.aplicacion.consulta.ListaVehiculoHandler;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.parqueadero.dominio.servicio.*;

@Configuration
public class ConfiguracionBean {
	
	@Bean
    public EntradaVehiculoHandler entradaVehiculoHandler(CrearVehiculoParqueaderoServicio crearServicio) {
        return new EntradaVehiculoHandler(crearServicio);
    }

    @Bean
    public CrearVehiculoParqueaderoServicio crearServicio(RepositorioRegistroVehiculo parqueaderoRepositorio){
        return new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }

    @Bean
    public ListaVehiculoHandler listaVehiculoHandler(BuscarVehiculoParqueaderoServicio buscarListaServicio) {
        return new ListaVehiculoHandler(buscarListaServicio);
    }
    
    @Bean
    public  BuscarVehiculoParqueaderoServicio listaVehiculoServicio(RepositorioRegistroVehiculo parqueaderoRepositorio){
        return new BuscarVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }
    
    @Bean
    public SalidaVehiculoHandler salidaVehiculoHandler(ActualizarSalidaVehiculoParqueaderoServicio actualizarServicio) {
        return new SalidaVehiculoHandler(actualizarServicio);
    }
    
    @Bean
    public ActualizarSalidaVehiculoParqueaderoServicio registerExitService(RepositorioRegistroVehiculo parqueaderoRepositorio){
        return new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }
    
    
}
