package co.com.ceiba.parqueadero.infraestructura.adaptador.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.parqueadero.infraestructura.adaptador.entidad.ParqueaderoEntidad;

public interface ParqueaderoRepositorioJPA extends CrudRepository<ParqueaderoEntidad, Integer>{
	
	@Query("SELECT COUNT(id) FROM ParqueaderoEntidad p WHERE p.tipoVehiculo = :tipoVehiculo AND p.fechaSalida IS NULL")
    int vehiculosPorTipo(@Param("tipoVehiculo") String tipoVehiculo);

    @Query("SELECT p FROM ParqueaderoEntidad p WHERE p.placa = :placa AND p.fechaSalida IS NULL")
    ParqueaderoEntidad buscarPorPlaca(@Param("placa") String placa);

    @Query("SELECT p FROM ParqueaderoEntidad p")
    List<ParqueaderoEntidad> buscarRegistroVehiculos();

    @Query("SELECT CASE WHEN COUNT(p.id) > 0 THEN true ELSE false END FROM ParqueaderoEntidad p WHERE p.placa = :placa AND p.fechaSalida IS NULL")
    boolean validarPlacaIngresada(@Param("placa") String placa);

}
