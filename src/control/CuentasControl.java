package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

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
				mcuentas.fillDB("./resources/usuarios_db.txt");
				Cuenta login = mcuentas.getCuenta(cuentaTexto);
				
				if(login == null)
				{
					//El nombre de usuario introducido no existe
					JOptionPane.showMessageDialog(null, 
	                        "No existe el usuario especificado", 
	                        "Error", 
	                        JOptionPane.ERROR_MESSAGE);
					GlobalInstances.recuperaPass.textField.setText("");
				}
				else
				{
					//El nombre de usuario introducido existe
					JOptionPane.showMessageDialog(null, 
	                        "Las contraseña es: " + login.getPass(), 
	                        "Contraseña cuenta", 
	                        JOptionPane.INFORMATION_MESSAGE);
					GlobalInstances.login.setVisible(true);
					GlobalInstances.recuperaPass.setVisible(false);
				}
				
			}
		});
	}
	
	
}
