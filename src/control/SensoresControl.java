package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

//import model.CuentasModel;
import model.SensoresModel;
import view.DejarSensor;
import view.DeleteSensor;
import view.GestionarSensor;
import view.GlobalInstances;
import view.Sensor;

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
					msensores.fillDB(pathSensores);
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
		
		
		GlobalInstances.addSensor.btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				msensores.clearSensores();
				msensores.fillDB(pathSensores);
				
				String tipo = (String) GlobalInstances.addSensor.choice.getSelectedItem();
				String nombre = GlobalInstances.addSensor.nombreSensor.getText();
				String ubicacion = GlobalInstances.addSensor.ubicacionSensor.getText();
				
				if((tipo != null) && (nombre != null) && (ubicacion != null))
				{
					Sensor sensor = new Sensor(nombre, tipo, ubicacion);
					msensores.addSensor(sensor);
					msensores.dump(pathSensores);
					
					JOptionPane.showMessageDialog(null, 
			                "Se ha añadido el sensor correctamente", 
			                "Sensor añadido", 
			                JOptionPane.INFORMATION_MESSAGE);
					
					GlobalInstances.addSensor.nombreSensor.setText("");
					GlobalInstances.addSensor.ubicacionSensor.setText("");
				}
			}
		});
		
		
		GlobalInstances.deleteSensor.btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				msensores.clearSensores();
				msensores.fillDB(pathSensores);
				
				//Queda más de un sensor por eliminar
				Object borrado = GlobalInstances.deleteSensor.choice.getSelectedItem();
				msensores.removeSensor((String) borrado);
				msensores.dump(pathSensores);
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
		
		
		GlobalInstances.menuOperador.btnGestionSensor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				msensores.clearSensores();
				msensores.fillDB(pathSensores);
				if(msensores.noGestionados() <= 0)
				{
					JOptionPane.showMessageDialog(null, 
			                "No hay sensores por gestionar", 
			                "Sensores gestionados", 
			                JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					//Para refrescar la tabla de sensores
					GlobalInstances.gestionarSensor = new GestionarSensor();
					
					GlobalInstances.gestionarSensor.setVisible(true);
					GlobalInstances.menuOperador.setVisible(false);					
				}

			}
		});
		
		
		GlobalInstances.menuOperador.btnDejarDeGestionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				msensores.fillDB(pathSensores);
				if(msensores.gestionados(GlobalInstances.cuenta.getName()) <= 0)
				{
					JOptionPane.showMessageDialog(null, 
			                "No hay sensores por dejar de gestionar para su cuenta", 
			                "Sensores gestionados", 
			                JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					GlobalInstances.dejarSensor = new DejarSensor();
					GlobalInstances.dejarSensor.setVisible(true);
					GlobalInstances.menuOperador.setVisible(false);
				}
				
			}
		});
		
		
		GlobalInstances.gestionarSensor.btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String nombreSensor = (String) GlobalInstances.gestionarSensor.choice.getSelectedItem();
				Sensor sensor = msensores.getSensor(nombreSensor);
				
				msensores.removeSensor(nombreSensor);
				sensor.setOperador(GlobalInstances.cuenta.getName());
				msensores.addSensor(sensor);
				
				msensores.dump("./resources/sensores.txt");
				
				GlobalInstances.gestionarSensor.choice.removeItem(nombreSensor);
				
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
	}
}
