package co.com.ceiba.parqueadero.dominio.constantes;

public final class ConstantesVigilante {
	
	private ConstantesVigilante() {}
	
	public static final int CUPO_MAXIMO_MOTOS = 10;
	public static final int CUPO_MAXIMO_CARROS = 20;
	
	public static final double PRECIO_CARRO_HORA = 1000;
	public static final double PRECIO_MOTO_HORA = 500;
	public static final double PRECIO_CARRO_DIA = 8000;
	public static final double PRECIO_MOTO_DIA = 4000;
	public static final double PRECIO_ADICIONAL = 2000;
	
	public static final int  CILINDRAJE_ALTO = 500;
	
	public static final int HORAS_MAXIMAS_HORA_POR_DIA = 9;
	public static final int HORAS_MAXIMAS_POR_DIA = 24;
	
	public static final String INICIAL_NO_PERMITIDA = "A";
	
	public static final int DIA_DOMINGO = 1;
	public static final int DIA_LUNES = 2;
	
	public static final String TIPO_CARRO  = "CARRO";
	public static final String TIPO_MOTO  = "MOTO";
	public static final String PLACA_ABC123  = "ABC123";
	public static final String PLACA_WSD123  = "WSD123";
	
	public static final int MINUTOS_POR_HORA = 60;
	public static final int CERO = 0;	
	
	public static final String MENSAJE_ERROR_SISTEMA = "Error en el sistema.";
	public static final String MENSAJE_TIPO_VEHICULO_NULO ="Debe ingresar un tipo de vehículo";
	public static final String ERROR_PLACA_NULA = "Debe ingresar un valor correcto para la placa";
	public static final String MENSAJE_TIPO_VEHICULO_VALIDO = "El tipo de vehículo ingresado es válido.";
	public static final String MENSAJE_ERROR_TIPO_VEHICULO ="El tipo de vehículo ingresado no es válido.";
	public static final String MENSAJE_ERROR_ACTUALIZAR = "El registro actual presenta errores de actualización.";
	public static final String MENSAJE_VEHICULO_EN_PARQUEADERO = "El vehículo ya se encuentra en en parqueadero.";
	public static final String MENSAJE_NO_VEHICULO_EN_PARQUEADERO = "El vehículo no se encuentra en en parqueadero.";
	public static final String MENSAJE_NO_CUPO_DISPONIBLE = "El parqueadero no cuenta actualmente con espacio disponible.";
	public static final String MENSAJE_CILINDRAJE_NO_VALIDO = "El cilindraje es necesario para registro en el parqueadero.";
	public static final String MENSAJE_PLACA_NO_VALIDA = "La placa que se está ingresando presenta restricción para el día actual.";

	public static final int  MILISEGUNDOS_A_MINUTOS = 60000;

	
}
