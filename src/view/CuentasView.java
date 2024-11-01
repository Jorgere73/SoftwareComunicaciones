package view;

import java.util.HashMap;

public class CuentasView
{
	public CuentasView() {}
	
	public void print(HashMap<Integer,Cuenta> cuentasBD) {
		System.out.println("Cuentas en la Base de Datos de Cuentas\n");
		for(HashMap.Entry<Integer,Cuenta> entradaTabla: cuentasBD.entrySet() ) {
			int clave = entradaTabla.getKey();
			Cuenta cuenta = entradaTabla.getValue();
			//System.out.println("Clave: " + clave + " " + cuenta.toString()); 
		}
 }
}