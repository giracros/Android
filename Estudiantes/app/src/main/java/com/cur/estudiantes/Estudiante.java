package com.cur.estudiantes;

import java.io.Serializable;

/**
 * Nombre del paquete com.cur.estudiantes
 * Creado por danielfuentes en la fecha 12/11/14.
 * Todos los derechos reservados
 * Email: giracros@gmail.com
 * Mobile: 3013366588
 * Nombre del proyecto Estudiantes.
 */
public class Estudiante implements Serializable {

    private int id;
    private int carnet;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    private double nota3;

    public Estudiante() {}

    public Estudiante(int carnet, String nombre, String apellido,
                      double nota1, double nota2, double nota3) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getDefinitiva() {
        double i = 3;
        double j=this.nota1+this.nota2+this.nota3;
        double definitiva = j/i;
        return definitiva;
    }

    @Override
    public String toString() {
        return this.nombre + ",  Carnet " + this.carnet + ",  " +String.format("Definitiva %1.1f", this.getDefinitiva());
        //return this.nombre + this.carnet+ ", Definitiva: " + Double.toString(this.getDefinitiva());
    }

}
