package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RecuperaPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField;
	public JButton btnRecupera;

	/**
	 * Create the frame.
	 */
	public RecuperaPassword() {
		setTitle("Recupera tu password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduce la cuenta");
		lblNewLabel.setBounds(139, 39, 260, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(58, 89, 340, 38);
		
		
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnRecupera = new JButton("Recupera");
		
		btnRecupera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRecupera.setBounds(217, 172, 162, 47);
		contentPane.add(btnRecupera);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				GlobalInstances.login.setVisible(true);
				GlobalInstances.recuperaPass.setVisible(false);
			}
		});
		btnVolver.setBounds(58, 172, 147, 47);
		contentPane.add(btnVolver);
	}
}
