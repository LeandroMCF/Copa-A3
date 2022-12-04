package minhatela;

import java.sql.Connection; 
import java.sql.DriverManager; 

public class ConextionString { 
private static String host = "localhost";     
private static String porta = "3306";     
private static String db = "db_base";     
private static String usuario = "adm";     
private static String senha = "260220041910"; 
    public static Connection obterConexao () throws Exception{ 
        String url = String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC", 
    host, porta, db); 
        return DriverManager.getConnection(url, usuario, senha); 
    } 
} 
