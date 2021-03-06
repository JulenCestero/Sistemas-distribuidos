package servlet;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddData extends HttpServlet implements SingleThreadModel{
	String resultsDir;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//first, set the "content type" header of the response
		res.setContentType("text/html");
		//Get client's form data
		HttpSession session = req.getSession(true);
		String user = (String)session.getAttribute("usuario");
		String pass = (String)session.getAttribute("pass");
		if(user.isEmpty()){ // ERROR!
			PrintWriter toClient = res.getWriter();
			toClient.print("<html>");
			toClient.print("<title>ERROR</title>");
			toClient.print("Acceso denegado");
			toClient.print("</html>");
			toClient.close();
		}
		if(req.getParameter("nombre") == "" || req.getParameter("apellido") == "" || req.getParameter("email") == "" || req.getParameter("postal") == ""){
			PrintWriter toClient = res.getWriter();
			toClient.print("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Formulario</title></head><body><h1>Hola " + user + ", completa el registro, pero ahora de forma correcta y rellenando todos los huecos, por favor :)</h1><form action=\"http://localhost:8080/Ejercicio_3/AddData\" method=\"POST\"><input type=hidden name=formulario value=resultadoFormulario><br><br>Nombre: <input type=text name=nombre><br><br>Apellido: <input type=text name=apellido><br><br>E-Mail: <input type=text name=email><br><br>Direcci�n Postal: <input type=text name=postal><br><br><input type=submit value=\"Enviar\"><input type=reset></form></body></html>");
			toClient.close();
		}else{
			session.setAttribute("nombre", req.getParameter("nombre"));
			session.setAttribute("apellido", req.getParameter("apellido"));
			session.setAttribute("email", req.getParameter("email"));
			session.setAttribute("postal", req.getParameter("postal"));
			PrintWriter toClient = res.getWriter();
			toClient.print("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Confirm</title></head><body><h1>Ya falta poco " + user + "!<br><h2>�Son todos estos datos correctos?</h2><form action=\"http://localhost:8080/Ejercicio_3/Confirm\" method=\"POST\"><input type=hidden name=registro value=resultadoRegistro><br><br><b>Nombre y apellidos: </b>" + req.getParameter("nombre") + " " + req.getParameter("apellido") + "<br><br><b>E-Mail: </b>" + req.getParameter("email") + "<br><br><b>Direcci�n Postal: </b>" + req.getParameter("postal") + "<br><br><input type=submit value=\"Enviar\"></form><form action=\"Registro\" method=\"POST\"><input type=submit value=\"Modificar!\"></input></form></body></html>");
			toClient.close();
		}		
	}	
}
