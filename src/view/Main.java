package view;

public class Main 
{
	public static void main(String[] args)
	{
		GlobalInstances.init = new Initial();
		GlobalInstances.login = new Login();
		GlobalInstances.registro = new Registro();
		GlobalInstances.menuGestor = new MenuGestor();
		GlobalInstances.menuOperador = new MenuOperador();
		
		GlobalInstances.init.setVisible(true);
	}
}
