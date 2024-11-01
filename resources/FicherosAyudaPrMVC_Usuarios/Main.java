package pr_MVC;

public class Main {

	public static void main(String[] args) {
		Usuario u1, u2;
		
		UsuarioModel db = new UsuarioModel();
		
		db.fillDB("usuarios_db.txt");
		
		u1 = db.getUsuario("andres");
		if (u1 != null) System.out.println(u1.toString());
		
		u1 = db.getUsuario("carlos");
		if (u1 != null) System.out.println(u1.toString());
		
		u2 = new Usuario("pepe", "poiuy678", 'o');
		db.addUsuario(u2);
		
		u1 = db.getUsuario("pepe");
		if (u1 != null) System.out.println(u1.toString());

	}

}
