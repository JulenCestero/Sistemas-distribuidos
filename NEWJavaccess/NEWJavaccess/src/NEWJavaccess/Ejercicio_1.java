package NEWJavaccess;

import java.sql.*;

public class Ejercicio_1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		String url = "jdbc:ucanaccess://C://Users/JULEN/Documents/GitHub/Sistemas distribuidos/NEWJavaccess/P3_BBDD2.accdb";
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM Barcos DESC";
		ResultSet result = statement.executeQuery(sql);
		while(result.next()){
			System.out.print(result.getString("Matrícula")+"|");
			System.out.println(result.getString("Nombre"));
		}
		connection.close();
	}

}
