package view;

import control.CuentasControl;

public class Main 
{
	public static void main(String[] args)
	{
		GlobalInstances.init = new Initial();
		GlobalInstances.login = new Login();
		GlobalInstances.registro = new Registro();
		GlobalInstances.menuGestor = new MenuGestor();
		GlobalInstances.menuOperador = new MenuOperador();
		GlobalInstances.addSensor = new AddSensor();
		GlobalInstances.deleteSensor = new DeleteSensor();
		GlobalInstances.gestionarSensor = new GestionarSensor();
		GlobalInstances.listaIncidencias = new ListadoIncidencias();
		GlobalInstances.recuperaPass = new RecuperaPassword();
		
		CuentasControl ccuentas = new CuentasControl();
		
		GlobalInstances.init.setVisible(true);
	}
}
