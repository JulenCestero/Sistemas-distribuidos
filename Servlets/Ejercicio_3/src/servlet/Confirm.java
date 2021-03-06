package servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Confirm extends HttpServlet implements SingleThreadModel{
	String resultsDir;
	String url = "jdbc:ucanaccess://C:/Users/JULEN/Documents/GitHub/Sistemas distribuidos/Servlets/Ejercicio_3/WebContent/WEB-INF/lib/database.accdb";

	public Boolean validateUser(String user, String pass, String nombre, String apellido, String email, String postal) throws SQLException{
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		String sql = "INSERT INTO P4Ejer4 (USUARIO, PASSWORD, EMAIL, DIRECCION, Nombre, Apellido) VALUES ('" + user + "', '" + pass + "', '" + email + "' , '" + postal + "', '" + nombre +"', '" + apellido +"')";
		int nrows = statement.executeUpdate(sql);
		connection.close();
		if(nrows == 0) return false;
		return true;
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//first, set the "content type" header of the response
		res.setContentType("text/html");
		//Get client's form data
		HttpSession session = req.getSession(true);
		String user = (String)session.getAttribute("usuario");
		String pass = (String)session.getAttribute("pass");
		String nombre = (String)session.getAttribute("nombre");
		String apellido = (String)session.getAttribute("apellido");
		String email = (String)session.getAttribute("email");
		String postal = (String)session.getAttribute("postal");
		if(user.isEmpty()){ // ERROR!
			PrintWriter toClient = res.getWriter();
			toClient.print("<html>");
			toClient.print("<title>ERROR</title>");
			toClient.print("Acceso denegado");
			toClient.print("</html>");
			toClient.close();
		}
		if(user.isEmpty()){ // ERROR!
			PrintWriter toClient = res.getWriter();
			toClient.print("<html>");
			toClient.print("<title>ERROR</title>");
			toClient.print("Acceso denegado");
			toClient.print("</html>");
			toClient.close();
		}
		try {
			
			Boolean response = validateUser(user, pass, nombre, apellido, email, postal);
			if(response == true){
				PrintWriter toClient = res.getWriter();
				toClient.print("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Correcto!</title></head><body><h1>PERFECTO!</h1><h2>Registro realizado!</h2></body></html>");
				toClient.close();
			}else{
				PrintWriter toClient = res.getWriter();
				toClient.print("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Error!</title></head><body><h1>OH OH!</h1><h2>Algo fue mal con el registro...</h2></body></html>");
				toClient.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
