package com.farmaback.farmaback;

import com.farmaback.farmaback.clases.Doctor;
import com.farmaback.farmaback.clases.Medicine;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServeMedicines", value = "/ServeMedicines")
public class ServeMedicines extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email"); // Obtiene el parámetro "email" de la solicitud
        int session = Integer.parseInt(request.getParameter("session")); // Obtiene el parámetro "session" de la solicitud y lo convierte a int
        Doctor doctor = new Doctor(); // Crea un nuevo objeto Doctor
        boolean verif = doctor.isLogged(email,session); // Llama al método isLogged del objeto Doctor con los parámetros email y session
        String error = null; // Inicializa la variable error con el valor null

        if (verif == true){ // Si verif es igual a true
            ArrayList<Medicine> medicines = doctor.listMedicins(); // Llama al método listMedicins del objeto Doctor y asigna el valor devuelto a la variable medicines

            Gson gson = new Gson();
            String json = gson.toJson(medicines); // Convierte el ArrayList de medicamentos a formato JSON

            response.setContentType("application/json");
            response.getWriter().write(json); // Escribe el JSON en la respuesta

        }else { // De lo contrario
            response.getWriter().write(error); // Escribe el valor de la variable error en la respuesta
        }
    }

}
