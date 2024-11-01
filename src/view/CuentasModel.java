package view;

import java.util.HashMap;

public class CuentasModel 
{
	HashMap<Integer, Cuenta> cuentasDB;
	int key = 0;
	
	public CuentasModel()
	{
		cuentasDB = new HashMap<Integer, Cuenta>();
	}
	
	public void addCuenta(Cuenta cuenta)
	{
		key++;
		cuentasDB.put(key, cuenta);
	}
	
	public Cuenta getCuenta(int key)
	{
		return cuentasDB.get(key);
	}
	
	public void removeCuenta(int key)
	{
		cuentasDB.remove(key);
	}
	
	public HashMap<Integer, Cuenta> getDB()
	{
		return cuentasDB;
	}
}
