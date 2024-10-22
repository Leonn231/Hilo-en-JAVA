package org.example;

public class Ingrediente {
    private String nombre;

    public Ingrediente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

