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
    private VistaEstudiante vista;
    private Estudiante[] arregloEstudiantes; // Uso de arreglos solicitado

    public ControladorEstudiante(VistaEstudiante vista) {
        this.vista = vista;
    }

    public void iniciar() {
        int cantidad = vista.solicitarCantidadEstudiantes();
        
        // Inicializamos el arreglo con el tamaño 'n' ingresado
        arregloEstudiantes = new Estudiante[cantidad];

        // Llenado del arreglo
        for (int i = 0; i < arregloEstudiantes.length; i++) {
            int codigo = vista.solicitarCodigo(i + 1);
            String nombre = vista.solicitarNombre();
            double notaDesarrollo = vista.solicitarNota("Desarrollo (Software y Hardware)");
            double notaMatematica = vista.solicitarNota("Matemática");

            // Uso del constructor para crear el objeto y guardarlo en el arreglo
            arregloEstudiantes[i] = new Estudiante(codigo, nombre, notaDesarrollo, notaMatematica);
        }

        generarReporte();
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
