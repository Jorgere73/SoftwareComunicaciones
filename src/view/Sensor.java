package view;

public class Sensor 
{
	private String tipo;
	private String name;
	private String ubicacion;
	
	public Sensor(String name, String tipo, String ubicacion)
	{
		this.tipo = tipo;
		this.name = name;
		this.ubicacion = ubicacion;
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
