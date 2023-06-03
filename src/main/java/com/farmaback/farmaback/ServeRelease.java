package com.farmaback.farmaback;

import com.farmaback.farmaback.clases.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServRel", value = "/ServRel")
public class ServeRelease extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("mail"); // Obtiene el parámetro "mail" de la solicitud
        int session = Integer.parseInt(request.getParameter("session")); // Obtiene el parámetro "session" de la solicitud y lo convierte a int
        int xip = Integer.parseInt(request.getParameter("xip")); // Obtiene el parámetro "xip" de la solicitud y lo convierte a int
        String pacientes = request.getParameter("pacientes"); // Obtiene el parámetro "pacientes" de la solicitud
        int medicamentos = Integer.parseInt(request.getParameter("medicamentos")); // Obtiene el parámetro "medicamentos" de la solicitud y lo convierte a int
        String date = request.getParameter("date"); // Obtiene el parámetro "date" de la solicitud

        String devolver = "null"; // Inicializa la variable devolver con el valor "null"
        boolean verify= false; // Inicializa la variable verify con el valor false
        try {
            Database.setXip(email,session,xip,pacientes,medicamentos,date); // Llama al método setXip de la clase Database con los parámetros obtenidos de la solicitud
            verify = Database.setXip(email,session,xip,pacientes,medicamentos,date);; // Llama al método setXip de la clase Database con los parámetros obtenidos de la solicitud y asigna el valor devuelto a la variable verify
            if (verify == true){ // Si verify es igual a true
                devolver ="correcto"; // Asigna el valor "correcto" a la variable devolver
            }
        }catch (Exception e){
            System.out.println("Error en verify"); // Imprime un mensaje de error en caso de excepción
        }

        response.getWriter().write(devolver); // Escribe el valor de la variable devolver en la respuesta

    }
}
