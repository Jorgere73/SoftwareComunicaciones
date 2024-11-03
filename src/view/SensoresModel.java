package view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class SensoresModel 
{
	private HashMap<String, Sensor> sensoresDB;
	
	public SensoresModel()
	{
		sensoresDB = new HashMap<String, Sensor>();
	}
	
	public void addSensor(Sensor sensor) {
		sensoresDB.put(sensor.getName(), sensor);
	}
	
	public Sensor getSensor(String login) {
		return sensoresDB.get(login);
	}
	
	public void removeSensor(String login)
	{
		sensoresDB.remove(login);
	}
	
	public void clearSensores()
	{
		sensoresDB.clear();
	}
	public HashMap<String, Sensor> getSensores()
	{
		return sensoresDB;
	}
	
	
	public void fillDB(String fileName) {
		try(FileReader fr = new FileReader(fileName);
				Scanner scanner = new Scanner(fr)
				) {
			
			while(scanner.hasNext()) {
				if(scanner.hasNext()) {
					String data = scanner.nextLine();
					String[] pieces = data.split("\t");
					String loginName = pieces[0];
					String ubicacion  = pieces[1];
					String type      = pieces[2];
					addSensor(new Sensor(loginName,type, ubicacion));
				} // if
			} // while
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dump(String nombreFichero) 
	{
		 FileWriter fichero = null;
		 PrintWriter pw = null;
		 try
		 {
			 fichero = new FileWriter(nombreFichero);
			 pw = new PrintWriter(fichero);
			 for( Entry<String, Sensor> entradaTabla:sensoresDB.entrySet()){
				 	String name = entradaTabla.getKey();
				 	Sensor sensor= entradaTabla.getValue();
				 	pw.println(sensor.getName() + "\t" + sensor.getUbicacion() + "\t" + sensor.getTipo());
			 }
		 } 
		 catch (Exception e) 
		 {
			 e.printStackTrace();
		 } 
		 finally 
		 {
			 try 
			 {
				 if (null != fichero) fichero.close();
			 } 
			 catch (Exception e2) 
			 {
				 e2.printStackTrace();
			 }
		 }
	}
}
