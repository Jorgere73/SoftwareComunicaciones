package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CuentasModel;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.Color;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JRadioButton rdbtnGestor;
	private CuentasModel mcuentas;

	/**
	 * Create the frame.
	 */
	public Registro() {
		mcuentas = new CuentasModel();
		mcuentas.fillDB("./resources/usuarios_db.txt");
		
		setTitle("Registro de nuevos usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccioneUnRol = new JLabel("Seleccione un rol");
		lblSeleccioneUnRol.setBounds(33, 0, 124, 17);
		contentPane.add(lblSeleccioneUnRol);
		
		textField = new JTextField();
		textField.setBounds(92, 106, 285, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(92, 83, 60, 17);
		contentPane.add(lblNombre);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(92, 154, 285, 25);
		contentPane.add(passwordField);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(92, 139, 114, 17);
		contentPane.add(lblContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(92, 208, 285, 25);
		contentPane.add(passwordField_1);
		
		JLabel lblRepitaLaContrasea = new JLabel("Repita la contraseña");
		lblRepitaLaContrasea.setBounds(92, 187, 180, 17);
		contentPane.add(lblRepitaLaContrasea);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.GREEN);
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char type = rdbtnGestor.isSelected() ? 'a' : 'o';
				String name = textField.getText();
				if(Arrays.equals(passwordField.getPassword(), passwordField_1.getPassword()))
				{
					
					//Contraseñas coinciden -> crear cuenta
					String password = new String(passwordField.getPassword());
					Cuenta cuenta = new Cuenta(name, password, type);
					
					textField.setText("");
					passwordField.setText("");
					
					mcuentas.addCuenta(cuenta);
					//Guardar la cuenta en el archivo .txt
					mcuentas.dump("./resources/usuarios_db.txt");
					JOptionPane.showMessageDialog(null, 
	                        "Cuenta registrada correctamente", 
	                        "Registro de cuentas", 
	                        JOptionPane.INFORMATION_MESSAGE);
					
				}
				else
				{
					//Contraseñas no coinciden
					passwordField.setText("");
					passwordField_1.setText("");
					JOptionPane.showMessageDialog(null, 
	                        "Las contraseñas introducidas no coinciden.", 
	                        "Error de registro", 
	                        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(112, 233, 94, 17);
		contentPane.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GlobalInstances.init.setVisible(true);
				GlobalInstances.registro.setVisible(false);
			}
		});
		btnVolver.setBounds(218, 233, 114, 17);
		contentPane.add(btnVolver);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 24, 114, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Para que al seleccionar un botón se deseleccione el otro
		ButtonGroup grupoBotones = new ButtonGroup();
		
		JRadioButton rdbtnOperador = new JRadioButton("Operador");
		rdbtnOperador.setBounds(10, 8, 93, 23);
		panel.add(rdbtnOperador);
		rdbtnOperador.setSelected(true);
		
		rdbtnGestor = new JRadioButton("Gestor");
		rdbtnGestor.setBounds(10, 32, 73, 23);
		panel.add(rdbtnGestor);
		
		grupoBotones.add(rdbtnOperador);
		grupoBotones.add(rdbtnGestor);
	}
}
