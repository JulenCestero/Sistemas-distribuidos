package servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Registro extends HttpServlet implements SingleThreadModel{
	String resultsDir;
	String url = "jdbc:ucanaccess://C:/Users/JULEN/Documents/GitHub/Sistemas distribuidos/Servlets/Ejercicio_3/WebContent/WEB-INF/lib/database.accdb";
	
	public Boolean isNameInDb(String user) throws SQLException{
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		String sql = "SELECT USUARIO FROM P4Ejer4";
		ResultSet result = statement.executeQuery(sql);
		connection.close();
		while(result.next()){
			if(result.getString("USUARIO").equals(user)) return true;
		}
		return false;
	}
	

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//first, set the "content type" header of the response
		HttpSession session = req.getSession(true);
		res.setContentType("text/html");
		//Get client's form data
		String user = (String)session.getAttribute("usuario");
		String pass = (String)session.getAttribute("pass");
		if(req.getParameter("user") != null){
			user = req.getParameter("user");
			pass = req.getParameter("pass");
		}
		try {
			if(isNameInDb(user)){
				PrintWriter toClient = res.getWriter();
				toClient.print("<html>");
				toClient.print("<title>ERROR</title>");
				toClient.print("El usuario " + user + " ya est� en uso Introduzca otro nombre");
				toClient.print("</html>");
				toClient.close();
				session.invalidate();
			}else{
				session.setAttribute("usuario", user);
				session.setAttribute("pass", pass);
				PrintWriter toClient = res.getWriter();
				toClient.print("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Formulario</title></head><body><h1>Hola " + user + ", completa el registro</h1><form action=\"http://localhost:8080/Ejercicio_3/AddData\" method=\"POST\"><input type=hidden name=formulario value=resultadoFormulario><br><br>Nombre: <input type=text name=nombre><br><br>Apellido: <input type=text name=apellido><br><br>E-Mail: <input type=text name=email><br><br>Direcci�n Postal: <input type=text name=postal><br><br><input type=submit value=\"Enviar\"><input type=reset></form></body></html>");
				toClient.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
