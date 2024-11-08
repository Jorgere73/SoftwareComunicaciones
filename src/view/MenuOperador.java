package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CuentasModel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuOperador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CuentasModel mcuentas;
	public JButton btnGestionSensor;
	public JButton btnDejarDeGestionar;
	public JButton btnDarseDeBaja;

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
		
		btnGestionSensor = new JButton("Gestionar nuevo sensor");
		
		btnGestionSensor.setBounds(52, 43, 336, 25);
		contentPane.add(btnGestionSensor);
		
		btnDejarDeGestionar = new JButton("Dejar de gestionar sensor");
		
		btnDejarDeGestionar.setBounds(52, 80, 336, 25);
		contentPane.add(btnDejarDeGestionar);
		
		JButton btnListadoDeMis = new JButton("Listado de mis sensores");
		btnListadoDeMis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				GlobalInstances.listaSensores = new ListadoSensores();
				
				GlobalInstances.listaSensores.setVisible(true);
				GlobalInstances.menuOperador.setVisible(false);
			}
		});
		btnListadoDeMis.setBounds(52, 117, 336, 25);
		contentPane.add(btnListadoDeMis);
		
		JButton btnListadoDeIncidencias = new JButton("Listado de incidencias");
		btnListadoDeIncidencias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				GlobalInstances.listaIncidencias.setVisible(true);
				GlobalInstances.menuOperador.setVisible(false);
			}
		});
		
		btnListadoDeIncidencias.setBounds(52, 154, 336, 25);
		contentPane.add(btnListadoDeIncidencias);
		
		btnDarseDeBaja = new JButton("Darse de baja");
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
