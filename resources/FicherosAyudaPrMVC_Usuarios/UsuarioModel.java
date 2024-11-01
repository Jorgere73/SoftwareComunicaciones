package pr_MVC;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class UsuarioModel {
	HashMap<String,Usuario> usuariosDB;
	
	public UsuarioModel() {
		usuariosDB = new HashMap<String, Usuario>();
	}
	
	public void addUsuario(Usuario usuario) {
		usuariosDB.put(usuario.getLoginName(), usuario);
	}
	
	public Usuario getUsuario(String login) {
		return usuariosDB.get(login);
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
					addUsuario(new Usuario(loginName, password, type.charAt(0)));
				} // if
			} // while
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
