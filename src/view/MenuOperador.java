package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuOperador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CuentasModel mcuentas;

	/**
	 * Create the frame.
	 */
	public MenuOperador() {
		mcuentas = new CuentasModel();
		mcuentas.fillDB("./resources/usuarios_db.txt");
		
		setTitle("Menú de operador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActividad = new JLabel("¿Qué deseas realizar?");
		lblActividad.setBounds(139, 0, 167, 15);
		contentPane.add(lblActividad);
		
		JButton btnGestionSensor = new JButton("Gestionar nuevo sensor");
		btnGestionSensor.setBounds(52, 43, 336, 25);
		contentPane.add(btnGestionSensor);
		
		JButton btnDejarDeGestionar = new JButton("Dejar de gestionar sensor");
		btnDejarDeGestionar.setBounds(52, 80, 336, 25);
		contentPane.add(btnDejarDeGestionar);
		
		JButton btnListadoDeMis = new JButton("Listado de mis sensores");
		btnListadoDeMis.setBounds(52, 117, 336, 25);
		contentPane.add(btnListadoDeMis);
		
		JButton btnListadoDeIncidencias = new JButton("Listado de incidencias");
		btnListadoDeIncidencias.setBounds(52, 154, 336, 25);
		contentPane.add(btnListadoDeIncidencias);
		
		JButton btnDarseDeBaja = new JButton("Darse de baja");
		btnDarseDeBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int response = JOptionPane.showConfirmDialog(null, 
		                "¿Quieres dar de baja a la cuenta?", 
		                "Seleccione una opción", 
		                JOptionPane.YES_NO_OPTION);
				if(response == JOptionPane.YES_OPTION)
				{
					mcuentas.removeCuenta(GlobalInstances.cuenta.name);
					mcuentas.dump("./resources/usuarios_db.txt");
					GlobalInstances.init.setVisible(true);
					GlobalInstances.menuOperador.setVisible(false);
				}
				
			}
		});
		btnDarseDeBaja.setBackground(new Color(239, 41, 41));
		btnDarseDeBaja.setBounds(12, 211, 150, 39);
		contentPane.add(btnDarseDeBaja);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesión");
		btnCerrarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GlobalInstances.init.setVisible(true);
				GlobalInstances.menuOperador.setVisible(false);
			}
		});
		btnCerrarSesin.setBounds(273, 211, 150, 39);
		contentPane.add(btnCerrarSesin);
	}
}
