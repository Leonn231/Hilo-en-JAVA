package org.example;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Sancocho sancocho = new Sancocho();

        JOptionPane.showMessageDialog(null, "Haga su Sancocho", "Sancocho", JOptionPane.INFORMATION_MESSAGE);

        // Agregar o quitar ingredientes
        boolean continuar = true;
        while (continuar) {
            String[] opciones = {"Agregar Ingrediente", "Quitar Ingrediente", "Continuar a Cocinar"};
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:",
                    "Sancocho", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Continuar a Cocinar")) {
                continuar = false;
            } else if (opcion.equals("Agregar Ingrediente")) {
                String nombreIngrediente = JOptionPane.showInputDialog("Ingresa el ingrediente:");
                if (nombreIngrediente != null && !nombreIngrediente.trim().isEmpty()) {
                    sancocho.agregarIngrediente(new Ingrediente(nombreIngrediente.trim()));
                }
            } else if (opcion.equals("Quitar Ingrediente")) {
                String nombreIngrediente = JOptionPane.showInputDialog("Ingresa el ingrediente que quieres quitar:");
                if (nombreIngrediente != null && !nombreIngrediente.trim().isEmpty()) {
                    sancocho.quitarIngrediente(new Ingrediente(nombreIngrediente.trim()));
                }
            }
        }

        // Ajustar el fuego
        String[] opcionesFuego = {"Sí", "No"};
        String fuego = (String) JOptionPane.showInputDialog(null, "¿cocinar a fuego alto?", "Sancocho",
                JOptionPane.QUESTION_MESSAGE, null, opcionesFuego, opcionesFuego[0]);

        sancocho.setFuegoAlto(fuego != null && fuego.equalsIgnoreCase("Sí"));

        // Ajustar el tiempo de cocción en el Main
        String tiempoStr;
        int tiempo = 0;
        do {
            tiempoStr = JOptionPane.showInputDialog("Ingresa el tiempo de cocción en segundos:");
            if (tiempoStr != null && tiempoStr.matches("\\d+")) {
                tiempo = Integer.parseInt(tiempoStr);
            }
        } while (tiempo <= 0);

        sancocho.setTiempoCoccion(tiempo); // Establecemos el tiempo directamente aquí

        // Confirmación final antes de iniciar la cocción
        JOptionPane.showMessageDialog(null, "El sancocho comenzará a cocinarse ahora.", "Sancocho", JOptionPane.INFORMATION_MESSAGE);

        // Iniciar el hilo de cocción
        CocinarSancocho cocinarSancocho = new CocinarSancocho(sancocho);
        cocinarSancocho.start(); // Se ejecuta el proceso de cocción en un hilo separado
    }
}


