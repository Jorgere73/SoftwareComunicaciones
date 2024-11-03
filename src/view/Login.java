package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private CuentasModel mcuentas;

	/**
	 * Create the frame.
	 */
	public Login() {
		mcuentas = new CuentasModel();
		
		setTitle("Inicio de sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(95, 37, 260, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(95, 12, 60, 17);
		contentPane.add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(95, 78, 94, 17);
		contentPane.add(lblContrasea);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				mcuentas.clearCuentas();
				mcuentas.fillDB("./resources/usuarios_db.txt");
				String login = textField.getText();
				//Devuelve un char[] por seguridad para que la contraseña no se mantenga en memoria
				char[] password = passwordField.getPassword();
				
				Cuenta cuentaLogin = mcuentas.getCuenta(login);
				
				if(cuentaLogin != null)
				{
					if(Arrays.equals(password, cuentaLogin.getPass().toCharArray()))
					{
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
						passwordField.setText("");
					}
				}
				else
				{
					//No existe esa cuenta
					JOptionPane.showMessageDialog(null, 
	                        "El usuario introducido es incorrecto.", 
	                        "Error de autenticación", 
	                        JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					passwordField.setText("");
				}
				
			}
		});
		btnAceptar.setBounds(128, 145, 105, 27);
		contentPane.add(btnAceptar);
		
		JLabel lblhasOlvidadoTu = new JLabel("¿Has olvidado tu contraseña?");
		lblhasOlvidadoTu.setBounds(128, 184, 227, 17);
		contentPane.add(lblhasOlvidadoTu);
		
		JButton btnRecuperaTuContrasea = new JButton("Recupera tu contraseña");
		btnRecuperaTuContrasea.setBounds(128, 213, 201, 27);
		contentPane.add(btnRecuperaTuContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 104, 260, 29);
		contentPane.add(passwordField);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GlobalInstances.init.setVisible(true);
				GlobalInstances.login.setVisible(false);
			}
		});
		btnVolver.setBounds(250, 145, 105, 27);
		contentPane.add(btnVolver);
	}
}
