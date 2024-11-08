package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.CuentasModel;
import view.Cuenta;
import view.GlobalInstances;

public class CuentasControl {
	//TODO Hacer listeners publicos para todos los botones que realicen acciones con las bases y moverlos a CuentasControl y SensorControl
	public CuentasModel mcuentas;
	public String pathUsuarios = "./resources/usuarios_db.txt";
	
	public CuentasControl()
	{
		mcuentas = new CuentasModel();
		
		GlobalInstances.login.btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				mcuentas.clearCuentas();
				mcuentas.fillDB(pathUsuarios);
				String login = GlobalInstances.login.textField.getText();
				//Devuelve un char[] por seguridad para que la contraseña no se mantenga en memoria
				char[] password = GlobalInstances.login.passwordField.getPassword();
				
				Cuenta cuentaLogin = mcuentas.getCuenta(login);
				
				if(cuentaLogin != null)
				{
					if(Arrays.equals(password, cuentaLogin.getPass().toCharArray()))
					{
						GlobalInstances.login.textField.setText("");
						GlobalInstances.login.passwordField.setText("");
						GlobalInstances.cuenta = cuentaLogin;
						//Contraseña y usuario correctos
						if(cuentaLogin.getTipo() == 'o')
						{
							
							//Redirigir a menu de operador
							GlobalInstances.menuOperador.setVisible(true);
							GlobalInstances.login.setVisible(false);
						}
						else if(cuentaLogin.getTipo() == 'a')
						{
							//Redirigir a menu de gestor
							GlobalInstances.menuGestor.setVisible(true);
							GlobalInstances.login.setVisible(false);
						}
						 
					}
					else
					{
						//Usuario existe, pero contraseña incorrecta
						JOptionPane.showMessageDialog(null, 
		                        "La contraseña introducida es incorrecta.", 
		                        "Error de autenticación", 
		                        JOptionPane.ERROR_MESSAGE);
						GlobalInstances.login.passwordField.setText("");
					}
				}
				else
				{
					//No existe esa cuenta
					JOptionPane.showMessageDialog(null, 
	                        "El usuario introducido es incorrecto.", 
	                        "Error de autenticación", 
	                        JOptionPane.ERROR_MESSAGE);
					GlobalInstances.login.textField.setText("");
					GlobalInstances.login.passwordField.setText("");
				}
				
			}
		});
		
		
		//Boton aceptar de recuperar password
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
	                        "Las password es: " + login.getPass(), 
	                        "Password cuenta", 
	                        JOptionPane.INFORMATION_MESSAGE);
					GlobalInstances.login.setVisible(true);
					GlobalInstances.recuperaPass.setVisible(false);
				}
				
			}
		});
		
		//Boton de acep
		GlobalInstances.registro.btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mcuentas.clearCuentas();
				mcuentas.fillDB(pathUsuarios);
				char type = GlobalInstances.registro.rdbtnGestor.isSelected() ? 'a' : 'o';
				String name = GlobalInstances.registro.textField.getText();
				if(Arrays.equals(GlobalInstances.registro.passwordField.getPassword(), GlobalInstances.registro.passwordField_1.getPassword()))
				{
					
					//Contraseñas coinciden -> crear cuenta
					String password = new String(GlobalInstances.registro.passwordField.getPassword());
					Cuenta cuenta = new Cuenta(name, password, type);
					
					
					GlobalInstances.registro.textField.setText("");
					GlobalInstances.registro.passwordField.setText("");
					GlobalInstances.registro.passwordField_1.setText("");
					
					if(type == 'a' && mcuentas.ifadmin())
					{
						JOptionPane.showMessageDialog(null, 
		                        "Ya existe una cuenta de gestor en el sistema.", 
		                        "Error de registro", 
		                        JOptionPane.ERROR_MESSAGE);
						
						GlobalInstances.init.setVisible(true);
						GlobalInstances.registro.setVisible(false);
					}
					else
					{
					
						mcuentas.addCuenta(cuenta);
						//Guardar la cuenta en el archivo .txt
						mcuentas.dump(pathUsuarios);
						JOptionPane.showMessageDialog(null, 
								"Cuenta registrada correctamente", 
								"Registro de cuentas", 
								JOptionPane.INFORMATION_MESSAGE);
						GlobalInstances.init.setVisible(true);
						GlobalInstances.registro.setVisible(false);
					}
				}
				else
				{
					//Contraseñas no coinciden
					GlobalInstances.registro.passwordField.setText("");
					GlobalInstances.registro.passwordField_1.setText("");
					JOptionPane.showMessageDialog(null, 
	                        "Las contraseñas introducidas no coinciden.", 
	                        "Error de registro", 
	                        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		GlobalInstances.menuGestor.btnDarseDeBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				mcuentas.clearCuentas();
				mcuentas.fillDB(pathUsuarios);
				int response = JOptionPane.showConfirmDialog(null, 
		                "¿Quieres dar de baja a la cuenta?", 
		                "Seleccione una opción", 
		                JOptionPane.YES_NO_OPTION);
				if(response == JOptionPane.YES_OPTION)
				{
					mcuentas.removeCuenta(GlobalInstances.cuenta.getName());
					mcuentas.dump(pathUsuarios);
					GlobalInstances.init.setVisible(true);
					GlobalInstances.menuGestor.setVisible(false);
				}
			}
		});
	}
	
	
}
