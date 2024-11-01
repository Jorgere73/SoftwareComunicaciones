package view;

public class Cuenta 
{
	//Operador = 0, Gestor = 1
	public int tipo;
	//Nombre de la cuenta
	public String name;
	//Contraseña para la cuenta
	public String pass;
	
	public Cuenta(int tipo, String name, String pass)
	{
		this.tipo = tipo;
		this.name = name;
		this.pass = pass;
	}
	
	/*public String toString()
	{
		return name + " " + tipo + " " + pass;
	}*/
}
