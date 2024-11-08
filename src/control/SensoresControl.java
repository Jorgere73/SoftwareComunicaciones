package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

//import model.CuentasModel;
import model.SensoresModel;
import view.DeleteSensor;
import view.GlobalInstances;

public class SensoresControl 
{
	//public CuentasModel mcuentas = new CuentasModel();
	public SensoresModel msensores;
	String pathSensores = "./resources/sensores.txt";
	
	public SensoresControl()
	{
		msensores = new SensoresModel();
		
		GlobalInstances.menuGestor.btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(GlobalInstances.menuGestor.rdbtnAgregarSensor.isSelected())
				{
					//Abrir ventana añadir sensor
					GlobalInstances.addSensor.setVisible(true);
					GlobalInstances.menuGestor.setVisible(false);
				}
				else
				{
					//Abrir ventana eliminar sensor
					msensores.clearSensores();
					msensores.fillDB("./resources/sensores.txt");
					if(msensores.getSensores().size() > 0)
					{
						GlobalInstances.deleteSensor = new DeleteSensor();
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
	}
}
