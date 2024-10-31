package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Initial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlobalInstances.init = new Initial();
					GlobalInstances.login = new Login();
					GlobalInstances.registro = new Registro();
					GlobalInstances.init.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Initial() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Initial.class.getResource("/resources/uc3m.png")));
		setTitle("Bienvenido a mi granja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonLogin = new JButton("Iniciar Sesión");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Dejamos de ver nuestra ventana 
				GlobalInstances.init.setVisible(false);
				//Vemos la nueva creada
				GlobalInstances.login.setVisible(true);
			}
		});
		botonLogin.setBounds(157, 162, 138, 27);
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(botonLogin);
		
		JLabel lblElijaUnaOpcin = new JLabel("Elija una opción");
		lblElijaUnaOpcin.setBounds(172, 12, 105, 17);
		contentPane.add(lblElijaUnaOpcin);
		
		JButton botonRegistro = new JButton("Registrarse");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GlobalInstances.init.setVisible(false);
				GlobalInstances.registro.setVisible(true);
			}
		});
		botonRegistro.setBounds(157, 70, 138, 27);
		contentPane.add(botonRegistro);
	}
}
