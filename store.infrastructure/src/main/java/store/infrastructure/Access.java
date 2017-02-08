package store.infrastructure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Access {
	private static String ip;
	private String user;
	private String password;
	protected String connectionString;
	protected final static String sqlServerDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	protected final static String mySqlDriver = "com.mysql.jdbc.Driver";
	
	/**
	 * 
	 */
	public Access(){
		Path path = Paths.get("/home/eduardo/Java/dbconfig.cfg");
		if(Files.exists(path)){
			List<String> dados = null;
			try {
				dados = Files.readAllLines(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(dados != null){
				if(dados.size() == 3){
					ip = dados.get(0);
					this.user = dados.get(1);
					this.password = dados.get(2);
				}
			}
		}
		
		//jdbc:mysql://localhost:3306/teste_crud
		
		if(!ip.isEmpty())
			connectionString = String.format("jdbc:mysql://%s", ip);
	}
	
	/**
	 * com.microsoft.sqlserver.jdbc.SQLServerDriver
	 */
	
	/**
	 * 
	 */
	protected String getIP(){
		return ip;
	}
	
	/**
	 * 
	 */
	protected String getUser(){
		return user;
	}
	
	/**
	 * 
	 */
	protected String getPassword(){
		return password;
	}
	
}
