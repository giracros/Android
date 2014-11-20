package com.grupoandroid.parcialcontactos;

public class Empleado {

    private int codEmpleado;
    private String nomEmpleado;
    private int numHorasSemana;
    private double valorHora;

    public Empleado() {
    }

    public Empleado(int codEmpleado, String nomEmpleado, int numHorasSemana, double valorHora) {
        this.codEmpleado = codEmpleado;
        this.nomEmpleado = nomEmpleado;
        this.numHorasSemana = numHorasSemana;
        this.valorHora = valorHora;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public int getNumHorasSemana() {
        return numHorasSemana;
    }

    public void setNumHorasSemana(int numHorasSemana) {
        this.numHorasSemana = numHorasSemana;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return String.format("%6d", this.codEmpleado) + " | " + this.nomEmpleado;
    }

    public double getPago() {
        return this.numHorasSemana * this.valorHora;
    }

}
