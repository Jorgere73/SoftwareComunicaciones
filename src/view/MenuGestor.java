package view;

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
	private SensoresModel msensores;
	/**
	 * Create the frame.
	 */
	public MenuGestor() 
	{
		
		mcuentas = new CuentasModel();
		msensores = new SensoresModel();
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
		rdbtnAgregarSensor.setSelected(true);
		contentPane.add(rdbtnAgregarSensor);
		
		JRadioButton rdbtnEliminarSensor = new JRadioButton("Eliminar Sensor");
		rdbtnEliminarSensor.setBounds(141, 96, 149, 23);
		contentPane.add(rdbtnEliminarSensor);
		
		bgroup.add(rdbtnAgregarSensor);
		bgroup.add(rdbtnEliminarSensor);
		
		
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
					mcuentas.removeCuenta(GlobalInstances.cuenta.getName());
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
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(rdbtnAgregarSensor.isSelected())
				{
					//Abrir ventana añadir sensor
					GlobalInstances.addSensor.setVisible(true);
					GlobalInstances.menuGestor.setVisible(false);
				}
				else
				{
					//Abrir ventana eliminar sensor
					msensores.fillDB("./resources/sensores.txt");
					if(msensores.getSensores().size() > 0)
					{
						GlobalInstances.deleteSensor.setVisible(true);
						GlobalInstances.menuGestor.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, 
				                "No tiene sensores registrados para eliminar", 
				                "Error", 
				                JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		btnAceptar.setBounds(141, 140, 149, 36);
		contentPane.add(btnAceptar);
		
	}
}
