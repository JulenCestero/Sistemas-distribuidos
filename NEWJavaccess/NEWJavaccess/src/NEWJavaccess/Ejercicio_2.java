package NEWJavaccess;

import java.sql.*;


public class Ejercicio_2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}catch(ClassNotFoundException ex){
			System.out.println("Error de ClassNotFoundException" + ex);
			System.exit(0);
		}
		String url = "jdbc:ucanaccess:" + args[0];
		try {
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			String sql = args[1];
			ResultSet result = statement.executeQuery(sql);
			ResultSetMetaData rmeta = result.getMetaData();
			int numColumns = rmeta.getColumnCount();
			for(int ii = 1; ii <= numColumns; ++ii){
				if(ii < numColumns){
					System.out.print(rmeta.getColumnName(ii) + "|");
				}else{
					System.out.println(rmeta.getColumnName(ii));
				}
			}
			while(result.next()){
				for(int ii = 1; ii <= numColumns; ++ii){
					if(ii < numColumns){
						System.out.print(result.getString(rmeta.getColumnName(ii)) + "|");
					}else{
						System.out.println(result.getString(rmeta.getColumnName(ii)));
					}
				}
			}
			connection.close();
		}catch(SQLException ex){
			System.out.println("Error de SQLException:" + ex);
			System.exit(0);
		}

	}

}
