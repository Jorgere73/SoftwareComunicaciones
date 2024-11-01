package view;

public class Main 
{
	public static void main(String[] args)
	{
		GlobalInstances.init = new Initial();
		GlobalInstances.login = new Login();
		GlobalInstances.registro = new Registro();
		GlobalInstances.init.setVisible(true);
	}
}
