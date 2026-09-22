/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.estudiantetecnologia;

import Vista.VistaEstudiante;
import controlador.ControladorEstudiante;

/**
 *
 * @author juans
 */
public class EstudianteTecnologia {

    public static void main(String[] args) {
     // Inicialización de la Vista y el Controlador
        VistaEstudiante vista = new VistaEstudiante();
        ControladorEstudiante controlador = new ControladorEstudiante(vista);
        
        // Ejecución de la aplicación
        controlador.iniciar();
    }
}
