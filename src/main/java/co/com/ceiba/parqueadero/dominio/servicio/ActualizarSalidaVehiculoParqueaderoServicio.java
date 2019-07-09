package co.com.ceiba.parqueadero.dominio.servicio;

import java.util.Calendar;

import co.com.ceiba.parqueadero.dominio.constantes.ConstantesVigilante;
import co.com.ceiba.parqueadero.dominio.excepciones.ExistenciaVehiculoExcepcion;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.modelo.ValidarVigilante;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;

public class ActualizarSalidaVehiculoParqueaderoServicio {

	private RepositorioRegistroVehiculo parqueaderoRepositorio;
	
	public ActualizarSalidaVehiculoParqueaderoServicio(RepositorioRegistroVehiculo parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public double actualizar(String placa){
		ValidarVigilante.validarDatoObligatorio(placa, ConstantesVigilante.ERROR_PLACA_NULA);
		Vigilante parqueadero = validarRegistro(placa);
		parqueadero.setFechaSalida(Calendar.getInstance().getTime());
		if(parqueadero.getTipoVehiculo().equalsIgnoreCase(ConstantesVigilante.TIPO_MOTO)) {
			calcularPrecioMoto(parqueadero);
		}else{
			calcularPrecioCarro(parqueadero);
		}
		
        this.parqueaderoRepositorio.crearVehiculo(parqueadero);
        return parqueadero.getTotal();
    }
	
	private Vigilante validarRegistro(String placa) {
		Vigilante parqueadero = this.parqueaderoRepositorio.buscarVehiculo(placa);
		if (parqueadero == null) {
			throw new ExistenciaVehiculoExcepcion(ConstantesVigilante.MENSAJE_NO_VEHICULO_EN_PARQUEADERO);
		}
		return parqueadero;
	}
	
	public void calcularPrecioMoto(Vigilante registry) {
        long value;
        double milisegund = (registry.getFechaSalida().getTime() - registry.getFechaIngreso().getTime());
        double hour = (milisegund/3600000);
        double minute = (milisegund/60000);
        long totalHour = Math.round(hour);
        long totalMinute = Math.round(minute);
        int totalDay = (int)  totalHour / 24;
        int  totalHourNewDay = (int) totalHour % 24;


        if(totalHour < 9){
            if((totalMinute >= 2) && (totalHour == 0)){
                value = 500;
            }else{
                value = totalHour * 500;
            }
        }else if(totalHourNewDay == 0 || (totalHourNewDay >= 9 && totalHourNewDay < 24)){
            value = (4000 * (totalDay == 0 ? 1:totalDay));
        }else{
            value = ((4000 * totalDay) + (totalHourNewDay * 500));
        }
        
        if(Integer.valueOf(registry.getCilindraje()) > 500 ){
            value = value + 2000;
        }
        
        registry.setTotal(value);
    }
	
	public void calcularPrecioCarro(Vigilante parqueadero) {
        long total;
        double miliseg = (parqueadero.getFechaSalida().getTime() - parqueadero.getFechaIngreso().getTime());
        double horaCarro = (miliseg/3600000);
        double minutosCarro = (miliseg/60000);
        long totalHora = Math.round(horaCarro);
        long totalMinutos = Math.round(minutosCarro);
        int totalDia = (int)  totalHora / 24;
        int totalHoraNuevoDia = (int) totalHora % 24;


        if(totalHora < 9){
            if((totalMinutos >= 2) && (totalHora == 0)){
            	total = 1000;
            }else{
            	total = totalHora * 1000;
            }
        }else if(totalHoraNuevoDia == 0 || (totalHoraNuevoDia >= 9 && totalHoraNuevoDia < 24)){
        	total = (8000 * (totalDia == 0 ? 1:totalDia));
        }else{
        	total = ((8000 * totalDia) + (totalHoraNuevoDia * 1000));
        }
        
        parqueadero.setTotal(total);
    }
}
