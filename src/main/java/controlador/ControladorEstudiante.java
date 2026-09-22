/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author juans
 */


import Modelo.Estudiante;
import Vista.VistaEstudiante;

public class ControladorEstudiante {
    private final VistaEstudiante vista;
    private Estudiante[] arregloEstudiantes;

    public ControladorEstudiante(VistaEstudiante vista) {
        this.vista = vista;
    }

    public void iniciar() {
        int cantidad = vista.solicitarCantidadEstudiantes();
        
        // Inicializa el arreglo con el tamaño 'n' ingresado
        arregloEstudiantes = new Estudiante[cantidad];

        // Se llena el arreglo
        for (int i = 0; i < arregloEstudiantes.length; i++) {
            int codigo = vista.solicitarCodigo(i + 1);
            String nombre = vista.solicitarNombre();
            double notaDesarrollo = vista.solicitarNota("Desarrollo (Software y Hardware)");
            double notaMatematica = vista.solicitarNota("Matemática");

            // Uso del constructor para crear el objeto y guardarlo en el arreglo
            arregloEstudiantes[i] = new Estudiante(codigo, nombre, notaDesarrollo, notaMatematica);
        }

        generarReporte();

        // Estudiantes cuya definitiva supera la nota límite
        double notaLimite = vista.solicitarNotaLimite();
        mostrarEstudiantesSuperioresALimite(notaLimite);
    }

    // No retorna nada: solo muestra en pantalla los estudiantes con definitiva superior a notaLimite
    private void mostrarEstudiantesSuperioresALimite(double notaLimite) {
        String reporte = "--- ESTUDIANTES CON DEFINITIVA SUPERIOR A " + String.format("%.1f", notaLimite) + " ---\n\n";
        boolean hayEstudiantes = false;

        for (int i = 0; i < arregloEstudiantes.length; i++) {
            Estudiante est = arregloEstudiantes[i];

            if (est.calcularDefinitiva() > notaLimite) {
                reporte += "Código: " + est.getCodigo() + "\n";
                reporte += "Nombre: " + est.getNombre() + "\n";
                reporte += "Nota Definitiva: " + String.format("%.2f", est.calcularDefinitiva()) + "\n";
                reporte += "----------------------------------------\n";
                hayEstudiantes = true;
            }
        }

        if (!hayEstudiantes) {
            reporte += "Ningún estudiante supera la nota límite.\n";
        }

        vista.mostrarMensaje(reporte);
    }

    private void generarReporte() {
        String reporte = "--- REPORTE FINAL DE ESTUDIANTES ---\n\n";

        for (int i = 0; i < arregloEstudiantes.length; i++) {
            Estudiante est = arregloEstudiantes[i];
            
            reporte += "Código: " + est.getCodigo() + "\n";
            reporte += "Nombre: " + est.getNombre() + "\n";
            reporte += "Nota Definitiva: " + String.format("%.2f", est.calcularDefinitiva()) + "\n";
            reporte += "Estado: " + est.obtenerEstadoAprobacion() + "\n";
            reporte += "----------------------------------------\n";
        }

        vista.mostrarMensaje(reporte);
    }
}