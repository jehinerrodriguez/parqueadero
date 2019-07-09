package co.com.ceiba.parqueadero.infraestructura.excepcion;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.com.ceiba.parqueadero.dominio.constantes.ConstantesVigilante;
import co.com.ceiba.parqueadero.dominio.excepciones.*;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ManejadorExcepcion {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorExcepcion.class);
    
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorExcepcion(){
        CODIGOS_ESTADO.put(ValorRequeridoExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(VehiculoDuplicadoExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(PlacaExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(TipoVehiculoExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ValidarCupoExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExistenciaVehiculoExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ActualizacionExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcepcionInfraestructura> handleAllExceptions(ExcepcionInfraestructura excepcion) {
        ResponseEntity<ExcepcionInfraestructura> response;

        String nombre = excepcion.getClass().getSimpleName();
        String mensaje = excepcion.getMensajeExcepcion();
        Integer code = CODIGOS_ESTADO.get(nombre);

        if (code != null) {
        	ExcepcionInfraestructura error = new ExcepcionInfraestructura(nombre, mensaje);
            response = new ResponseEntity<>(error, HttpStatus.valueOf(code));
        } else {
            LOGGER.error(nombre, excepcion);
            ExcepcionInfraestructura error = new ExcepcionInfraestructura(nombre, ConstantesVigilante.MENSAJE_ERROR_SISTEMA);
            response = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }
}
