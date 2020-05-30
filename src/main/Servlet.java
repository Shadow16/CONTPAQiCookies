package main;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
@SuppressWarnings("serial")
public class Servlet extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
     
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
     
     String btn = request.getParameter("elmCook");
     if (btn != null && btn.equals("Eliminar cookies") ) {
    	 Cookie[] cookies = request.getCookies();
    	 if (cookies != null) {
         for(int i = 0; i < cookies.length; i++) {
              cookies[i].setMaxAge(0);
              response.addCookie(cookies[i]);
         } 
     	}
     }
      
   
      String nombre = request.getParameter("username");
      String password = request.getParameter("password");
      String genero = request.getParameter("gender");
      if (genero == null) {
    	  genero = "";
      }
      
      String edad = request.getParameter("age");
      if (edad == null ) {
    	  edad = "";
      }
      
      String lenguaje[] = request.getParameterValues("language");
      if (lenguaje == null ) {
    	  
      }
       
      String comentarios = request.getParameter("comments");
      String oculto = request.getParameter("secret");
      
      
      try {
    	  if (request.getParameter("cook").equals("on") ) {
    		  
    		  Cookie cookieNombre = new Cookie("01Usuario", nombre);
    		  cookieNombre.setMaxAge(3600);
    		  response.addCookie(cookieNombre);
    		  
    		  Cookie cookiePass = new Cookie("02Contrasena", password);
    		  cookiePass.setMaxAge(3600);
    		  response.addCookie(cookiePass);
    		  
    		  Cookie cookieGenero = new Cookie("03Genero", genero);
    		  cookieGenero.setMaxAge(3600);
    		  response.addCookie(cookieGenero);
    		  
    		  Cookie cookieEdad = new Cookie("04Edad", edad);
    		  cookieEdad.setMaxAge(3600); 
    		  response.addCookie(cookieEdad);
    		  
    		  if (lenguaje != null) {
    		  for (int i = 0; i < lenguaje.length; i++) {
    			  Cookie cookieHab = new Cookie("05Habilidades" + i, lenguaje[i]);
    			  cookieHab.setMaxAge(3600);
        		  response.addCookie(cookieHab);
    		  }
    		  } else {
    			  for (int i = 0; i < 4; i++) {
        			  Cookie cookieHab = new Cookie("05Habilidades" + i, "");
        			  cookieHab.setMaxAge(3600);
            		  response.addCookie(cookieHab);
        		  }
    		  }
    			 
    		  String cadenaCook = comentarios.replaceAll("[^A-Za-z0-9]+", "");
    		  Cookie cookieCom = new Cookie("06Comentarios", cadenaCook);
    		  cookieCom.setMaxAge(3600);
    		  response.addCookie(cookieCom);
    		  
   				
    	  } 
      } catch (NullPointerException e) {}
      
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html lang=\"es\"><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<link rel=\"stylesheet\"\r\n" + 
         		"	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n" + 
         		"	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n" + 
         		"	crossorigin=\"anonymous\">");
         out.println("<title>CONTPAQi Inicio</title></head>");
         out.println("<body>");
         out.println("<br />");
        
         out.println("<div class=\"container\">");
         out.println("<table style=\"width:80%\">");
         out.println("<tr>");
         out.println("<td><h1>Información del sitio</h1></td>");
         out.println("<td><a href=\"index.html\" class=\"btn btn-success\">Regresar</a> </td>");
         out.println("</tr>");
         out.println("</table>");
         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
         out.println("<p>PathInfo: " + request.getQueryString() + "</p>");
         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
         out.println("</div>");
         out.println("<br /><br />");
         
         out.println("<div class=\"container pservices\">");
         out.println("<h4>Datos del formulario</h4>");
         out.println("<table class=\"table table-dark table-hover \" style=\"width:40%\">");
         out.println("<tr><td>Usuario</td>");
         out.println("<td>" + nombre + "</td></tr>");
         out.println("<tr><td>Contraseña</td>");
         out.println("<td>" + password + "</td></tr>");
         out.println("<tr><td>Género</td>");
         out.println("<td>" + genero + "</td></tr>");
         out.println("<tr><td>Edad</td>");
         out.println("<td>" + edad + "</td></tr>");
         out.println("<tr><td>Habilidades</td>");
         
         out.println("<td>");
         if (lenguaje != null) {
         for (int i = 0; i <lenguaje.length; i++) {
        	 out.println( lenguaje[i] + "," );
         }
         }
         out.println("</td></tr>");
         
         out.println("<tr><td>Comentarios</td>");
         out.println("<td>" + comentarios + "</td></tr>");
         out.println("<tr><td>Num. secreto</td>");
         out.println("<td>" + oculto + "</td></tr>");
         out.println("</table>");
         out.println("</div>");
         
         out.println("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\r\n" + 
         		"		integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n" + 
         		"		crossorigin=\"anonymous\"></script>");
         out.println("<script\r\n" + 
         		"		src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\r\n" + 
         		"		integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\r\n" + 
         		"		crossorigin=\"anonymous\"></script>");
         out.println("<script\r\n" + 
         		"		src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\r\n" + 
         		"		integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\r\n" + 
         		"		crossorigin=\"anonymous\"></script>");
         out.println("</body>");
         out.println("</html>");
      
      } finally {
         out.close();  // Always close the output writer
      }
     
   }
}