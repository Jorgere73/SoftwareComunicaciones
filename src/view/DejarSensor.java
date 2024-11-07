package view;

import java.awt.EventQueue;
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

public class DejarSensor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private SensoresModel msensores;
	
	/**
	 * Create the frame.
	 */
	public DejarSensor() {
		setTitle("Gestionar nuevo sensor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccioneUnSensor = new JLabel("Seleccione un sensor para dejar de gestionarlo");
		lblSeleccioneUnSensor.setBounds(45, 10, 337, 15);
		contentPane.add(lblSeleccioneUnSensor);
		
		msensores = new SensoresModel();
		msensores.fillDB("./resources/sensores.txt");
		
		JComboBox<String> choice = new JComboBox<String>();
		choice.setBounds(45, 37, 364, 50);
		int i = 0;
		for(Entry<String, Sensor> entradaTabla:msensores.getSensores().entrySet())
		{
			if(entradaTabla.getValue().getOperador().equals(GlobalInstances.cuenta.getName()))
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
				GlobalInstances.dejarSensor.setVisible(false);
			}
		});
		btnCancelar.setBounds(32, 173, 136, 50);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String nombreSensor = (String) choice.getSelectedItem();
				Sensor sensor = msensores.getSensor(nombreSensor);
				
				msensores.removeSensor(nombreSensor);
				sensor.setOperador("Sin gestionar");
				msensores.addSensor(sensor);
				
				msensores.dump("./resources/sensores.txt");
				
				choice.removeItem(nombreSensor);
				
				JOptionPane.showMessageDialog(null, 
		                "Sensor eliminado de la gestión de su cuenta correctamente", 
		                "Sensor eliminado", 
		                JOptionPane.INFORMATION_MESSAGE);
				
				if(msensores.gestionados(GlobalInstances.cuenta.getName()) <= 0)
				{
					GlobalInstances.menuOperador.setVisible(true);
					GlobalInstances.dejarSensor.setVisible(false);
				}
			}
		});
		btnAceptar.setBounds(270, 173, 139, 50);
		contentPane.add(btnAceptar);
	}
}
