package view;

public class Cuenta 
{
	//Operador = 'o', Gestor = 'g'
	public char tipo;
	//Nombre de la cuenta
	public String name;
	//Contraseña para la cuenta
	public String pass;
	
	public Cuenta(String name, String pass, char tipo)
	{
		this.tipo = tipo;
		this.name = name;
		this.pass = pass;
	}
	
	public String toString() {
		return name + "\t" + pass + "\t" + tipo + "\n";
	}
	
	// gets
	public String getName() {
		return name;
	}
	
	public String getPass() {
		return pass;
	}
	
	public char getTipo() {
		return tipo;
	}
	
	// sets
	public void setname(String name) {
		this.name = name;
	}
	
	public void setPass(String password) {
		this.pass = password;
	}
	
	public void setTipo(char type) {
		this.tipo = type;
	}
}
