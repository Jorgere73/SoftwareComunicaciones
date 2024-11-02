package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuGestor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rdbtnAgregarSensor;
	private CuentasModel mcuentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGestor frame = new MenuGestor();
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
	public MenuGestor() {
		mcuentas = new CuentasModel();
		mcuentas.fillDB("./resources/usuarios_db.txt");
		
		setTitle("Menú de gestor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblquDeseaHacer = new JLabel("¿Qué desea hacer?");
		lblquDeseaHacer.setBounds(157, 0, 145, 21);
		contentPane.add(lblquDeseaHacer);
		
		ButtonGroup bgroup = new ButtonGroup();
		
		rdbtnAgregarSensor = new JRadioButton("Agregar Sensor");
		rdbtnAgregarSensor.setBounds(141, 55, 149, 23);
		contentPane.add(rdbtnAgregarSensor);
		
		JRadioButton rdbtnEliminarSensor = new JRadioButton("Eliminar Sensor");
		rdbtnEliminarSensor.setBounds(141, 96, 149, 23);
		contentPane.add(rdbtnEliminarSensor);
		
		bgroup.add(rdbtnAgregarSensor);
		bgroup.add(rdbtnEliminarSensor);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			}
		});
		btnAceptar.setBounds(157, 141, 117, 25);
		contentPane.add(btnAceptar);
		
		JButton btnDarseDeBaja = new JButton("Darse de baja");
		btnDarseDeBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int response = JOptionPane.showConfirmDialog(null, 
		                "¿Quieres dar de baja a la cuenta?", 
		                "Seleccione una opción", 
		                JOptionPane.YES_NO_OPTION);
				if(response == JOptionPane.YES_OPTION)
				{
					mcuentas.removeCuenta(GlobalInstances.cuenta.name);
					mcuentas.dump("./resources/usuarios_db.txt");
					GlobalInstances.init.setVisible(true);
					GlobalInstances.menuGestor.setVisible(false);
				}
			}
		});
		btnDarseDeBaja.setBackground(Color.RED);
		btnDarseDeBaja.setBounds(12, 214, 139, 36);
		contentPane.add(btnDarseDeBaja);
		
		JButton btnCerrarSesin = new JButton("Cerrar sesión");
		btnCerrarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GlobalInstances.init.setVisible(true);
				GlobalInstances.menuOperador.setVisible(false);
			}
		});
		btnCerrarSesin.setBounds(282, 214, 145, 36);
		contentPane.add(btnCerrarSesin);
	}
}
