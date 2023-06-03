package com.farmaback.farmaback.clases;

public class Medicine {

    private int id; // ID del medicamento
    private String name; // Nombre del medicamento
    private float tmax; // Temperatura máxima del medicamento
    private float tmin; // Temperatura mínima del medicamento

    // Constructor con todos los atributos
    public Medicine(int id, String name, float tmax, float tmin) {
        this.id = id;
        this.name = name;
        this.tmax = tmax;
        this.tmin = tmin;
    }

    // Constructor vacío
    public Medicine() {}

    // Getters y setters para los atributos de la clase
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getTmax() {
        return tmax;
    }
    public void setTmax(float tmax) {
        this.tmax = tmax;
    }
    public float getTmin() {
        return tmin;
    }
    public void setTmin(float tmin) {
        this.tmin = tmin;
    }

    public void load(int id){

    }
}
