package view;

public class GlobalInstances 
{
	public static Initial init;
	public static Login login;
	public static Registro registro;
	public static MenuGestor menuGestor;
	public static MenuOperador menuOperador;
	public static AddSensor addSensor;
	public static DeleteSensor deleteSensor;
	
	//Guarda la cuenta que se está usando en el momento
	public static Cuenta cuenta;
	
	private static GlobalInstances INSTANCE = null;
	
	private GlobalInstances() {}
	
	private static void createInstance() 
	{
		if(INSTANCE == null)
		{
			INSTANCE = new GlobalInstances();
		}
	}
	
	public static GlobalInstances getInstance() 
	{
		if(INSTANCE == null) createInstance();
		return INSTANCE;
	}
}
