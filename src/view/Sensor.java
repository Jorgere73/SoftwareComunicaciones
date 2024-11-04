package view;

public class Sensor 
{
	private String tipo;
	private String name;
	private String ubicacion;
	//Nombre del operador que está manejando el sensor
	private String operador;
	
	public Sensor(String name, String tipo, String ubicacion)
	{
		this.tipo = tipo;
		this.name = name;
		this.ubicacion = ubicacion;
		this.operador = "Sin gestionar";
	}
	
	public Sensor(String name, String tipo, String ubicacion, String operador)
	{
		this.tipo = tipo;
		this.name = name;
		this.ubicacion = ubicacion;
		this.operador = operador;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setOperador(String operador)
	{
		this.operador = operador;
	}

	public String getOperador()
	{
		return operador;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public void setTipo(String type) {
		this.tipo = type;
	}

}
