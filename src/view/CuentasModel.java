package view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
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
}
