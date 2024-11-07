package view;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.SensoresModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddSensor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreSensor;
	private JTextField ubicacionSensor;
	private SensoresModel msensores;

	/**
	 * Create the frame.
	 */
	public AddSensor() {
		msensores = new SensoresModel();
		
		setTitle("Añadir Sensor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccioneQuTipo = new JLabel("Seleccione qué tipo de sensor quiere añadir");
		lblSeleccioneQuTipo.setBounds(66, 10, 314, 15);
		contentPane.add(lblSeleccioneQuTipo);
		
		JComboBox<String> choice = new JComboBox<>();
		choice.setBounds(76, 44, 284, 38);
		choice.addItem("Temperatura exterior");
		choice.addItem("Temperatura interior");
		choice.addItem("CO2");
		choice.addItem("NH3");
		choice.addItem("Humedad");
		
		//Deja seleccionada de forma predeterminada la primera opción
		choice.setSelectedIndex(0);
		
		contentPane.add(choice);
		
		JLabel lblNombreDelSensor = new JLabel("Nombre del sensor");
		lblNombreDelSensor.setBounds(137, 138, 194, 24);
		contentPane.add(lblNombreDelSensor);
		
		nombreSensor = new JTextField();
		nombreSensor.setBounds(66, 184, 291, 38);
		contentPane.add(nombreSensor);
		nombreSensor.setColumns(10);
		
		JLabel lblUbicacinDelSensor = new JLabel("Ubicación del sensor");
		lblUbicacinDelSensor.setBounds(137, 234, 194, 24);
		contentPane.add(lblUbicacinDelSensor);
		
		ubicacionSensor = new JTextField();
		ubicacionSensor.setBounds(66, 270, 291, 38);
		contentPane.add(ubicacionSensor);
		ubicacionSensor.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				nombreSensor.setText("");
				ubicacionSensor.setText("");
				
				GlobalInstances.menuGestor.setVisible(true);
				GlobalInstances.addSensor.setVisible(false);
			}
		});
		btnCancelar.setBounds(30, 335, 136, 51);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Añadir");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				msensores.clearSensores();
				msensores.fillDB("./resources/sensores.txt");
				
				String tipo = (String) choice.getSelectedItem();
				String nombre = nombreSensor.getText();
				String ubicacion = ubicacionSensor.getText();
				
				if((tipo != null) && (nombre != null) && (ubicacion != null))
				{
					Sensor sensor = new Sensor(nombre, tipo, ubicacion);
					msensores.addSensor(sensor);
					msensores.dump("./resources/sensores.txt");
					
					JOptionPane.showMessageDialog(null, 
			                "Se ha añadido el sensor correctamente", 
			                "Sensor añadido", 
			                JOptionPane.INFORMATION_MESSAGE);
					
					nombreSensor.setText("");
					ubicacionSensor.setText("");
				}
			}
		});
		btnAceptar.setBounds(272, 335, 123, 51);
		contentPane.add(btnAceptar);
		
	}
}
