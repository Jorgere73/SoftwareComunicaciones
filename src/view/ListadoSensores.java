package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.SensoresModel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoSensores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private SensoresModel msensores;

	/**
	 * Create the frame.
	 */
	public ListadoSensores() {
		msensores = new SensoresModel();
		msensores.fillDB("./resources/sensores.txt");
		
		setTitle("Mis sensores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		String[] items = msensores.listarGestionados(GlobalInstances.cuenta.getName());
		
		
        contentPane.setLayout(null);
        
		setContentPane(contentPane);
		
		// Optionally, add a scroll pane to make the list scrollable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 53, 361, 139);
		
		// Add the scroll pane with the list to the frame
		contentPane.add(scrollPane);
		        
		// Create the JList and add items
		JList<String> list = new JList<>(items);
		scrollPane.setViewportView(list);
		        
		JLabel lblListaDeSensores = new JLabel("Lista de sensores de la cuenta");
		lblListaDeSensores.setBounds(99, 12, 253, 29);
		contentPane.add(lblListaDeSensores);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				GlobalInstances.menuOperador.setVisible(true);
				GlobalInstances.listaSensores.setVisible(false);
			}
		});
		btnVolver.setBounds(150, 203, 145, 47);
		contentPane.add(btnVolver);
		        
		        
	}
}
