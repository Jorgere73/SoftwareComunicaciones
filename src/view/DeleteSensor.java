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

public class DeleteSensor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private SensoresModel msensores;
	public JComboBox<String> choice;
	public JButton btnDelete;

	/**
	 * Create the frame.
	 */
	public DeleteSensor() {
		msensores = new SensoresModel();
		msensores.fillDB("./resources/sensores.txt");
		
		setTitle("Eliminar Sensor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIndiqueElNombre = new JLabel("Indique qué sensor desea eliminar");
		lblIndiqueElNombre.setBounds(79, 12, 298, 30);
		contentPane.add(lblIndiqueElNombre);
		
		choice = new JComboBox<String>();
		choice.setBounds(57, 54, 320, 36);
		int i = 0;
		for(Entry<String, Sensor> entradaTabla:msensores.getSensores().entrySet())
		{
			choice.addItem(entradaTabla.getKey());
			i++;
		}
		if(i > 0) choice.setSelectedIndex(0);
		contentPane.add(choice);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				GlobalInstances.menuGestor.setVisible(true);
				GlobalInstances.deleteSensor.setVisible(false);
			}
		});
		
		btnVolver.setBounds(57, 102, 132, 36);
		contentPane.add(btnVolver);
		
		btnDelete = new JButton("Eliminar");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				msensores.clearSensores();
				msensores.fillDB("./resources/sensores.txt");
				
				//Queda más de un sensor por eliminar
				Object borrado = GlobalInstances.deleteSensor.choice.getSelectedItem();
				msensores.removeSensor((String) borrado);
				msensores.dump("./resources/sensores.txt");
				GlobalInstances.deleteSensor.choice.removeItem(borrado);
				
				if(msensores.getSensores().size() < 1)
				{
					//Solo queda un sensor por eliminar
					JOptionPane.showMessageDialog(null, 
			                "No quedan más sensores por eliminar", 
			                "Sensor eliminado", 
			                JOptionPane.INFORMATION_MESSAGE);
					
					GlobalInstances.menuGestor.setVisible(true);
					GlobalInstances.deleteSensor.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, 
			                "Se ha eliminado el sensor correctamente", 
			                "Sensor eliminado", 
			                JOptionPane.INFORMATION_MESSAGE);
				}	
			}
		});
		btnDelete.setBounds(214, 102, 140, 36);
		contentPane.add(btnDelete);
	}
}
