package com.farmaback.farmaback;

import com.farmaback.farmaback.clases.Doctor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServeXips", value = "/ServeXips")
public class ServeXips extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email"); // Obtiene el parámetro "email" de la solicitud
        int session = Integer.parseInt(request.getParameter("session")); // Obtiene el parámetro "session" de la solicitud y lo convierte a int

        Doctor doctor = new Doctor(); // Crea un nuevo objeto Doctor
        boolean verif = doctor.isLogged(email,session); // Llama al método isLogged del objeto Doctor con los parámetros email y session

        String resp = null; // Inicializa la variable resp con el valor null

        if (verif == true){ // Si verif es igual a true
            try {
                doctor.load(email); // Llama al método load del objeto Doctor con el parámetro email
                doctor.loadReleaseList(); // Llama al método loadReleaseList del objeto Doctor
                resp = doctor.getTable(); // Llama al método getTable del objeto Doctor y asigna el valor devuelto a la variable resp
                response.getWriter().write(resp); // Escribe el valor de la variable resp en la respuesta
            }catch (Exception e){
                System.out.println("Error en carga de datos"); // Imprime un mensaje de error en caso de excepción
            }
        }else { // De lo contrario
            response.getWriter().write(resp); // Escribe el valor de la variable resp en la respuesta
        }
    }
}
