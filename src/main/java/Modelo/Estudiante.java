/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juans
 */


public class Estudiante {
    private int codigo;
    private String nombre;
    private double notaDesarrollo;
    private double notaMatematica;

    // Constructor
    public Estudiante(int codigo, String nombre, double notaDesarrollo, double notaMatematica) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.notaDesarrollo = notaDesarrollo;
        this.notaMatematica = notaMatematica;
    }

    // Métodos Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaDesarrollo() {
        return notaDesarrollo;
    }

    public void setNotaDesarrollo(double notaDesarrollo) {
        this.notaDesarrollo = notaDesarrollo;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    // Reglas de negocio
    public double calcularDefinitiva() {
        return (this.notaDesarrollo * 0.6) + (this.notaMatematica * 0.4);
    }

    public String obtenerEstadoAprobacion() {
        if (calcularDefinitiva() < 3.5) {
            return "NO APRUEBA";
        } else {
            return "SI APRUEBA";
        }
    }
}
