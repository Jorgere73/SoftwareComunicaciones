package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;
	public JButton btnAceptar;

	/**
	 * Create the frame.
	 */
	public Login() {
		
		setTitle("Inicio de sesion");
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
		
		JLabel lblContrasea = new JLabel("Password");
		lblContrasea.setBounds(95, 78, 94, 17);
		contentPane.add(lblContrasea);
		
		btnAceptar = new JButton("Aceptar");
		
		btnAceptar.setBounds(128, 145, 105, 27);
		contentPane.add(btnAceptar);
		
		JLabel lblhasOlvidadoTu = new JLabel("¿Has olvidado tu password?");
		lblhasOlvidadoTu.setBounds(128, 184, 227, 17);
		contentPane.add(lblhasOlvidadoTu);
		
		JButton btnRecuperaTuContrasea = new JButton("Recupera tu password");
		btnRecuperaTuContrasea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				GlobalInstances.recuperaPass.setVisible(true);
				GlobalInstances.login.setVisible(false);
			}
		});
		btnRecuperaTuContrasea.setBounds(128, 213, 201, 27);
		contentPane.add(btnRecuperaTuContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 104, 260, 29);
		contentPane.add(passwordField);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				passwordField.setText("");
				GlobalInstances.init.setVisible(true);
				GlobalInstances.login.setVisible(false);
			}
		});
		btnVolver.setBounds(250, 145, 105, 27);
		contentPane.add(btnVolver);
	}
}
