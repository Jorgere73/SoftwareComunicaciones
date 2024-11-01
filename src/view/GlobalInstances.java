package view;

public class GlobalInstances 
{
	public static Initial init;
	public static Login login;
	public static Registro registro;
	
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
