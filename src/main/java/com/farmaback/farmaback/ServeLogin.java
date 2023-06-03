package com.farmaback.farmaback;

import com.farmaback.farmaback.clases.Doctor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServeLogin", value = "/ServeLogin")
public class ServeLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Doctor doctor = new Doctor(); // Crea un nuevo objeto Doctor
        String email = request.getParameter("email"); // Obtiene el parámetro "email" de la solicitud
        String password = request.getParameter("password"); // Obtiene el parámetro "password" de la solicitud

        doctor.login(email,password); // Llama al método login del objeto Doctor con los parámetros email y password
        int sesion = doctor.getSesison(); // Obtiene el valor de la sesión del objeto Doctor

        if (sesion != 0){ // Si la sesión no es igual a cero
            response.getWriter().write(String.valueOf(sesion)); // Escribe el valor de la sesión en la respuesta
        }
        else{ // De lo contrario
            String nulll = null; // Crea una variable nula
            response.getWriter().write(nulll); // Escribe nulo en la respuesta
        }
    }
}
