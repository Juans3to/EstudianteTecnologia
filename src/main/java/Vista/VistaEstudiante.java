/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author juans
*/


import javax.swing.JOptionPane;

public class VistaEstudiante {

    public int solicitarCantidadEstudiantes() {
        String input = JOptionPane.showInputDialog(null, "¿Cuántos estudiantes de Tecnología desea registrar?", "Registro", JOptionPane.QUESTION_MESSAGE);
        return Integer.parseInt(input);
    }

    public int solicitarCodigo(int numeroEstudiante) {
        int codigo = 0;
        // Ciclo para garantizar que el código sea mayor a 21000
        while (codigo <= 21000) {
            String input = JOptionPane.showInputDialog(null, "Estudiante " + numeroEstudiante + "\nIngrese el código (Debe ser mayor a 21000):");
            codigo = Integer.parseInt(input);
            if (codigo <= 21000) {
                mostrarMensaje("Error: El código debe ser un valor superior a 21000.");
            }
        }
        return codigo;
    }

    public String solicitarNombre() {
        return JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante:");
    }

    public double solicitarNota(String materia) {
        String input = JOptionPane.showInputDialog(null, "Ingrese la nota de " + materia + ":");
        return Double.parseDouble(input);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}