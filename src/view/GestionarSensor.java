package view;

import java.util.Map.Entry;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.SensoresModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionarSensor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private SensoresModel msensores;
	public JButton btnAceptar;
	public JComboBox<String> choice;
	
	/**
	 * Create the frame.
	 */
	public GestionarSensor() {
		setTitle("Gestionar nuevo sensor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccioneUnSensor = new JLabel("Seleccione un sensor para gestionar");
		lblSeleccioneUnSensor.setBounds(92, 10, 261, 15);
		contentPane.add(lblSeleccioneUnSensor);
		
		msensores = new SensoresModel();
		msensores.fillDB("./resources/sensores.txt");
		
		JComboBox<String> choice = new JComboBox<String>();
		choice.setBounds(45, 37, 364, 50);
		int i = 0;
		for(Entry<String, Sensor> entradaTabla:msensores.getSensores().entrySet())
		{
			if(entradaTabla.getValue().getOperador().equals("Sin gestionar"))
			{
				choice.addItem(entradaTabla.getKey());
				i++;
			}
		}
		if(i > 0) choice.setSelectedIndex(0);
		contentPane.add(choice);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				GlobalInstances.menuOperador.setVisible(true);
				GlobalInstances.gestionarSensor.setVisible(false);
			}
		});
		btnCancelar.setBounds(32, 173, 136, 50);
		contentPane.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String nombreSensor = (String) choice.getSelectedItem();
				Sensor sensor = msensores.getSensor(nombreSensor);
				
				msensores.removeSensor(nombreSensor);
				sensor.setOperador(GlobalInstances.cuenta.getName());
				msensores.addSensor(sensor);
				
				msensores.dump("./resources/sensores.txt");
				
				choice.removeItem(nombreSensor);
				
				JOptionPane.showMessageDialog(null, 
		                "Sensor añadido a la gestión de su cuenta correctamente", 
		                "Sensor añadido", 
		                JOptionPane.INFORMATION_MESSAGE);
				
				if(msensores.noGestionados() <= 0)
				{
					GlobalInstances.menuOperador.setVisible(true);
					GlobalInstances.gestionarSensor.setVisible(false);
				}
			}
		});
		btnAceptar.setBounds(270, 173, 139, 50);
		contentPane.add(btnAceptar);
	}
}
