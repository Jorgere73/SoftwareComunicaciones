package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import view.Sensor;

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
	
	public int noGestionados()
	{
		int nogestionados = 0;
		for(Entry<String, Sensor> entradaTabla:sensoresDB.entrySet())
		{
			//Si está siendo gestionado...
			if(entradaTabla.getValue().getOperador().equals("Sin gestionar"))
			{
				nogestionados++;
			}
		}
		return nogestionados;
	}
	
	//Devuelve el número de sensores que son gestionados por la cuenta de gestor proporcionada
	public int gestionados(String operador)
	{
		int gestionados = 0;
		for(Entry<String, Sensor> entradaTabla:sensoresDB.entrySet())
		{
			if(entradaTabla.getValue().getOperador().equals(operador))
			{
				gestionados++;
			}
		}
		return gestionados;
	}
	
	//Devuelve el número de sensores que son gestionados por la cuenta de gestor proporcionada
		public String[] listarGestionados(String operador)
		{
			ArrayList<String> list = new ArrayList<String>();
			for(Entry<String, Sensor> entradaTabla:sensoresDB.entrySet())
			{
				if(entradaTabla.getValue().getOperador().equals(operador))
				{
					list.add(entradaTabla.getKey());
				}
			}
			
			String[] listGestionados =  list.toArray(new String[0]);
			return listGestionados;
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
					String operador = pieces[3];
					addSensor(new Sensor(loginName,type, ubicacion, operador));
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
				 	Sensor sensor= entradaTabla.getValue();
				 	pw.println(sensor.getName() + "\t" + sensor.getUbicacion() + "\t" + sensor.getTipo() + "\t" + sensor.getOperador());
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
