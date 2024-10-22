package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sancocho {
    private List<Ingrediente> ingredientes;
    private boolean fuegoAlto;
    private int tiempoCoccion;

    public Sancocho() {
        this.ingredientes = new ArrayList<>();
        this.fuegoAlto = true;  // Por defecto fuego alto
        this.tiempoCoccion = 0;
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
        System.out.println(ingrediente.getNombre() + " agregado.");
    }

    public void quitarIngrediente(Ingrediente ingrediente) {
        if (ingredientes.remove(ingrediente)) {
            System.out.println(ingrediente.getNombre() + " removido.");
        } else {
            System.out.println(ingrediente.getNombre() + " no está en el sancocho.");
        }
    }

    public void setFuegoAlto(boolean fuegoAlto) {
        this.fuegoAlto = fuegoAlto;
        System.out.println("Fuego ajustado a " + (fuegoAlto ? "alto" : "bajo"));
    }

    public void setTiempoCoccion(int tiempo) {
        this.tiempoCoccion = tiempo;
        System.out.println("Tiempo de cocción ajustado a " + tiempo + " segundos.");
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public boolean isFuegoAlto() {
        return fuegoAlto;
    }
}

