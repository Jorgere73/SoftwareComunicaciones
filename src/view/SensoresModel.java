package view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

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
}
