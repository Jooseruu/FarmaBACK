package com.farmaback.farmaback.clases;
import java.util.Date;

public class Xip {

    private int id; // ID del chip
    private Medicine medicine; // Medicamento del chip
    private Patient patient; // Paciente del chip
    private Date date; // Fecha del chip

    // Método para obtener una representación en forma de cadena del objeto
    @Override
    public String toString() {
        return "Xip{" +
                "id=" + id +
                ", medicine=" + medicine.getId() +
                ", patient=" + patient.getMail() +
                ", date=" + date +
                '}';
    }

    // Constructor con todos los atributos
    public Xip(int id, Medicine medicine, Patient patient, Date date) {
        this.id = id;
        this.medicine = medicine;
        this.patient = patient;
        this.date = date;
    }

    // Constructor vacío
    public Xip() { }

    // Getters y setters para los atributos de la clase
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Medicine getMedicine() {
        return medicine;
    }
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    // Método para cargar los datos del chip que corresponden al ID introducido
    public void load(int id) {
        Xip xip = Database.xipLoad(id); // Llama al método xipLoad de la clase Database con el parámetro id y asigna el valor devuelto a la variable xip
        setPatient(xip.getPatient()); // Asigna el paciente del objeto xip al objeto actual
        setMedicine(xip.getMedicine()); // Asigna el medicamento del objeto xip al objeto actual
        setDate(xip.getDate()); // Asigna la fecha del objeto xip al objeto actual
        setId(xip.getId()); // Asigna el ID del objeto xip al objeto actual
    }


}
