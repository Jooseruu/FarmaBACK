package com.farmaback.farmaback.clases;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor extends Persona{

    private String pass; // Contraseña del doctor
    private LocalDate lastLog; // Fecha del último inicio de sesión del doctor
    private int sesison; // Sesión del doctor
    private ArrayList<Xip> releaseList; // Lista de chips del doctor

    // Constructor con todos los atributos
    public Doctor(String name, String email, String pass, LocalDate lastlog, int session, ArrayList<Xip> relaseList) {
        super(name, email);
        this.pass = pass;
        this.lastLog = lastlog;
        this.sesison = session;
        this.releaseList = relaseList;
    }

    // Constructor vacío
    public Doctor(){
        super();
    }

    // Constructor sin la lista de chips
    public Doctor(String name, String email, String pass, LocalDate lastlog, int session) {
        super(name, email);
        this.pass = pass;
        this.lastLog = lastlog;
        this.sesison = session;
    }

    // Getters y setters para los atributos de la clase
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public LocalDate getLastLog() {
        return lastLog;
    }

    public void setLastLog(LocalDate lastLog) {
        this.lastLog = lastLog;
    }

    public int getSesison() {
        return sesison;
    }

    public void setSesison(int sesison) {
        this.sesison = sesison;
    }

    public ArrayList<Xip> getReleaseList() {
        return releaseList;
    }

    public void setReleaseList(ArrayList<Xip> releaseList) {
        this.releaseList = releaseList;
    }


    // Método para verificar si el correo electrónico y la sesión introducidos coinciden con los de la base de datos y cargar los datos del doctor
    public  boolean isLogged(String mail,int session) {
        boolean logged = false;
        Connection connection = Database.openconnection(); // Abre una conexión con la base de datos
        logged = Database.checkTable(connection,mail,session); // Llama al método checkTable de la clase Database con los parámetros connection, mail y session y asigna el valor devuelto a la variable logged
        return logged;
    }

    // Método para iniciar sesión y cargar los datos del doctor si el correo electrónico y la contraseña son correctos
    public void  login(String mail, String pass){
        boolean logged =false;
        Connection connection = Database.openconnection(); // Abre una conexión con la base de datos
        logged = Database.checkLog(connection,mail,pass); // Llama al método checkLog de la clase Database con los parámetros connection, mail y pass y asigna el valor devuelto a la variable logged
        if (logged == true){ // Si logged es igual a true
            load(mail); // Llama al método load con el parámetro mail
            loadReleaseList(); // Llama al método loadReleaseList
        }
    }



    // Método para cargar los datos del doctor que corresponden al correo electrónico introducido
    @Override
    public void load(String id) {
        Connection connection = Database.openconnection(); // Abre una conexión con la base de datos
        Doctor doc = Database.cargarDoc(connection,id); // Llama al método cargarDoc de la clase Database con los parámetros connection e id y asigna el valor devuelto a la variable doc
        setMail(doc.getMail()); // Asigna el correo electrónico del objeto doc al objeto actual
        setSesison(doc.getSesison()); // Asigna la sesión del objeto doc al objeto actual
        setName(doc.getName()); // Asigna el nombre del objeto doc al objeto actual
        setPass(doc.getPass()); // Asigna la contraseña del objeto doc al objeto actual
        setLastLog(doc.getLastLog()); // Asigna la fecha del último inicio de sesión del objeto doc al objeto actual
    }

    // Método para cargar en el array del doctor los xips de la base de datos que le corresponden
    public void  loadReleaseList(){
        Connection connection = Database.openconnection(); // Abre una conexión con la base de datos
        setReleaseList(Database.cargarChip(connection,this.getMail())); // Llama al método cargarChip de la clase Database con los parámetros connection y el correo electrónico del objeto actual y asigna el valor devuelto al atributo releaseList del objeto actual

    }
    public static void   loadReleaseList(String mail){
        Connection connection = Database.openconnection(); // Abre una conexión con la base de datos
        ArrayList<Xip> xips =
                Database.cargarChip(connection,mail); // Llama al método cargarChip de la clase Database con los parámetros connection y mail y asigna el valor devuelto a la variable xips

    }

    // Método para obtener una tabla HTML con todos los xips vigentes del doctor
    public  String getTable(){

        StringBuilder tabla = new StringBuilder();
        tabla.append("<table>");
        tabla.append("<thead>");
        tabla.append("<tr>" +
                "<th>Id</th>" +
                "<th>Doctor_Mail</th>" +
                "<th>Id_Medicina</th>" +
                "<th>Id_Paciente</th>" +
                "<th>Fecha</th>" +
                "</tr>");
        tabla.append("</thead>");
        tabla.append("<tbody>");
        // Recorre la lista de xips y agrega filas a la tabla
        for (Xip xip : this.getReleaseList()) {
            tabla.append("<tr>" +
                    "<td>'"+xip.getId()+"'</th>" +
                    "<td>'"+getMail()+"'</th>" +
                    "<td>'"+xip.getMedicine().getId()+"'</th>" +
                    "<td>'"+xip.getPatient().getMail()+"'</th>" +
                    "<td>'"+xip.getDate()+"'</th>" +
                    "</tr>");
        }
        tabla.append("</tbody>");
        tabla.append("</table>");
        return tabla.toString();
    }

    // Método para obtener una lista de pacientes
    public ArrayList<String> listPatients(){
        ArrayList<String> listPatient = Database.listPatient(); // Llama al método listPatient de la clase Database y asigna el valor devuelto a la variable listPatient

        return listPatient;
    }

    // Método para obtener una lista de medicamentos
    public ArrayList<Medicine> listMedicins(){
        ArrayList<Medicine> listMedicnins = Database.listMedicine(); // Llama al método listMedicine de la clase Database y asigna el valor devuelto a la variable listMedicnins
        return listMedicnins;
    }

    public boolean setXip(){
        boolean verify = false;

        return verify;
    }
}