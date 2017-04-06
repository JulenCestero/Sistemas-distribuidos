package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Registro extends HttpServlet implements SingleThreadModel{
	String resultsDir;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//first, set the "content type" header of the response
		res.setContentType("text/html");
		//Get client's form data
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		//Respond to the client
		PrintWriter toClient = res.getWriter();
		toClient.print("<html>");
		toClient.print("<title>REGISTRO ACTUALIZADO</title>");
		toClient.print("Usuario " + user + " registrado con exito!!");
		toClient.print("</html>");
		//Close the writer, the response is done
		toClient.close();
		
	}
	
}