package view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class CuentasModel 
{
	HashMap<String,Cuenta> cuentasDB;
	
	public CuentasModel() {
		cuentasDB = new HashMap<String, Cuenta>();
	}
	
	public void addCuenta(Cuenta cuenta) {
		cuentasDB.put(cuenta.getName(), cuenta);
	}
	
	public Cuenta getCuenta(String login) {
		return cuentasDB.get(login);
	}
	
	public void removeCuenta(String login)
	{
		cuentasDB.remove(login);
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
					String password  = pieces[1];
					String type      = pieces[2];
					addCuenta(new Cuenta(loginName, password, type.charAt(0)));
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
			 for( Entry<String, Cuenta> entradaTabla:cuentasDB.entrySet()){
				 	String name = entradaTabla.getKey();
				 	Cuenta cuenta = entradaTabla.getValue();
				 	pw.println(cuenta.getName() + "\t" + cuenta.getPass() + "\t" + cuenta.getTipo());
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
