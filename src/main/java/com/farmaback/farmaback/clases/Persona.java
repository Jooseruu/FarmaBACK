package com.farmaback.farmaback.clases;

public abstract class Persona {
    protected String name; // Nombre de la persona
    protected String mail; // Correo electrónico de la persona

    // Constructor con todos los atributos
    public Persona(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    // Constructor vacío
    public Persona(){};

    // Getters y setters para los atributos de la clase
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // Método abstracto para cargar los datos de la persona
    public abstract void load(String id);

}
