package org.example;
import javax.swing.*;

public class
CocinarSancocho extends Thread {
    private Sancocho sancocho;

    public CocinarSancocho(Sancocho sancocho) {
        this.sancocho = sancocho;
    }

    @Override
    public void run() {
        try {
            int tiempo = sancocho.getTiempoCoccion();
            boolean fuegoAlto = sancocho.isFuegoAlto();

            // Mostrar mensaje de cocción en JOptionPane
            String mensajeFuego = fuegoAlto ? "Cocinando a fuego alto..." : "Cocinando a fuego bajo...";
            JOptionPane.showMessageDialog(null, mensajeFuego, "Cocción del Sancocho", JOptionPane.INFORMATION_MESSAGE);

            // Simular cocción con sleep
            Thread.sleep(tiempo * 1000); // Simula la cocción

            // Control de quemado en fuego alto
            if (fuegoAlto && tiempo > 10) { // Si el tiempo es más de 10 segundos y a fuego alto
                JOptionPane.showMessageDialog(null, "El sancocho se quemó, severa loca", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Mostrar mensaje de cocción finalizada
                JOptionPane.showMessageDialog(null, "El sancocho está listo! Ingredientes: " + sancocho.getIngredientes(),
                        "Sancocho Completo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Error durante la cocción: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

