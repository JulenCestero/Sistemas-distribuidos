package NEWJavaccess;

import java.sql.*;
import java.io.*;

public class Ejercicio_4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}catch(ClassNotFoundException ex){
			System.out.println("Error de ClassNotFoundException" + ex);
			System.exit(0);
		}
		String url = "jdbc:ucanaccess://C://Users/JULEN/Documents/GitHub/Sistemas distribuidos/NEWJavaccess/P4_Ejer4.accdb";
		
		while(true){
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			BufferedReader InBuf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("User ('0000' to finish): ");
			String usuario = InBuf.readLine();
			if(usuario.equals("0000")){
				connection.close();
				break;
			}
			System.out.print("Password: ");
			String pass = InBuf.readLine();
			String sql = "SELECT PASSWORD FROM P4Ejer4 WHERE USUARIO='" + usuario + "'";
			ResultSet result = statement.executeQuery(sql);
			connection.close();
			if(result.next()){
				if(result.getString("PASSWORD").equals(pass)){
					System.out.println("You are in, baby");
					break;
				}
				else{
					System.out.println("Incorrect! Try again!");
				}
			}
			else{
				connection = DriverManager.getConnection(url);
				statement = connection.createStatement();
				sql = "INSERT INTO P4Ejer4 (USUARIO,PASSWORD) VALUES ('" + usuario + "', '" + pass + "')";
				int nrows = statement.executeUpdate(sql);
				System.out.println("Usuarios añadidos: " + nrows);
				connection.close();
			}
			
		}
		
	}

}
