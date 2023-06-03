package com.farmaback.farmaback.clases;

public class Patient extends Persona{

    // Método para cargar los datos del paciente que corresponden al correo electrónico introducido
    @Override
    public void load(String id) {
        Patient patient = Database.patientLoad(id); // Llama al método patientLoad de la clase Database con el parámetro id y asigna el valor devuelto a la variable patient
        setMail(patient.getMail()); // Asigna el correo electrónico del objeto patient al objeto actual
        setName(patient.getName()); // Asigna el nombre del objeto patient al objeto actual
    }

    // Constructor con todos los atributos
    public Patient(String name, String mail) {
        super(name, mail);
    }

    // Constructor vacío
    public Patient() {}

}
