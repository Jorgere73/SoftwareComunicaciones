package pr_MVC;
/*
 * Entidad Usuario
 * Un usuario está identificado por 
 *    - su loginName, 
 *    - su password y
 *    - su tipo: 'o' (operario), 'a' (administrador o gestor)
 */
public class Usuario {
	private String loginName;
	private String password;
	private char type;
	
	Usuario(String loginName, String password, char type){
		this.loginName = loginName;
		this.password = password;
		this.type = type;
	}
	
	public String toString() {
		return loginName + "\t" + password + "\t" + type + "\n";
	}
	
	// gets
	public String getLoginName() {
		return loginName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public char getType() {
		return type;
	}
	
	// sets
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setType(char type) {
		this.type = type;
	}
}
