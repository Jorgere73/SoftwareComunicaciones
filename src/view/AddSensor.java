package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Choice;

public class AddSensor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AddSensor() {
		setTitle("Añadir Sensor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*
		JLabel lblSeleccioneQuTipo = new JLabel("Seleccione qué tipo de sensor quiere añadir");
		lblSeleccioneQuTipo.setBounds(66, 10, 314, 15);
		contentPane.add(lblSeleccioneQuTipo);
		
		Choice choice = new Choice();
		choice.setBounds(112, 44, 219, 38);
		choice.add("Temperatura exterior");
		choice.add("Temperatura interior");
		choice.add("CO2");
		choice.add("NH3");
		choice.add("Humedad");
		
		contentPane.add(choice);
		*/
	}
}
