package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.CuentasModel;
import view.Cuenta;
import view.GlobalInstances;

public class CuentasControl {
	//TODO Hacer listeners publicos para todos los botones que realicen acciones con las bases y moverlos a CuentasControl y SensorControl
	//TODO Recuperar contraseña
	//TODO Solo un gestor, si hay más, da error
	public CuentasModel mcuentas;
	
	public CuentasControl()
	{
		mcuentas = new CuentasModel();
		
		GlobalInstances.recuperaPass.btnRecupera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String cuentaTexto = GlobalInstances.recuperaPass.textField.getText();
				mcuentas.fillDB("./resources/usuarios.txt");
				Cuenta login = mcuentas.getCuenta(cuentaTexto);
				
				if(login == null)
				{
					
				}
				
				
			}
		});
	}
	
	
}
