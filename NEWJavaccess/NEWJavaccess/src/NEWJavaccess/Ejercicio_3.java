package NEWJavaccess;

import java.sql.*;

public class Ejercicio_3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		String url="jdbc:ucanaccess:" + args[0];
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		String sql = args[1];
		int nrows = statement.executeUpdate(sql);
		System.out.println("Numero de registros modificados: " + nrows);
		connection.close();
	}

}
