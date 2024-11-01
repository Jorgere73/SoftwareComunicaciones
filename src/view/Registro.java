package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the frame.
	 */
	public Registro() {
		setTitle("Registro de nuevos usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnOperador = new JRadioButton("Operador");
		rdbtnOperador.setBounds(43, 24, 130, 25);
		contentPane.add(rdbtnOperador);
		
		JLabel lblSeleccioneUnRol = new JLabel("Seleccione un rol");
		lblSeleccioneUnRol.setBounds(33, 0, 124, 17);
		contentPane.add(lblSeleccioneUnRol);
		
		JRadioButton rdbtnGestor = new JRadioButton("Gestor");
		rdbtnGestor.setBounds(43, 53, 130, 25);
		contentPane.add(rdbtnGestor);
		
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
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
	}
}
