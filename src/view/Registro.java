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

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		rdbtnOperador.setBounds(43, 24, 82, 25);
		contentPane.add(rdbtnOperador);
		
		JLabel lblSeleccioneUnRol = new JLabel("Seleccione un rol");
		lblSeleccioneUnRol.setBounds(33, 0, 124, 17);
		contentPane.add(lblSeleccioneUnRol);
		
		JRadioButton rdbtnGestor = new JRadioButton("Gestor");
		rdbtnGestor.setBounds(43, 53, 130, 25);
		contentPane.add(rdbtnGestor);
		
		textField = new JTextField();
		textField.setBounds(92, 109, 285, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(92, 86, 60, 17);
		contentPane.add(lblNombre);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(92, 157, 285, 25);
		contentPane.add(passwordField);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(92, 139, 114, 17);
		contentPane.add(lblContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(92, 211, 285, 25);
		contentPane.add(passwordField_1);
		
		JLabel lblRepitaLaContrasea = new JLabel("Repita la contraseña");
		lblRepitaLaContrasea.setBounds(92, 190, 143, 17);
		contentPane.add(lblRepitaLaContrasea);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(178, 243, 94, 17);
		contentPane.add(btnAceptar);
	}
}
