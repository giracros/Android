package com.danielfuentes.taller2.listview_contactos;

/**
 * Nombre del paquete com.danielfuentes.taller2.listview_contactos
 * Creado por danielfuentes en la fecha 11/13/14.
 * Todos los derechos reservados
 * Email: giracros@gmail.com
 * Mobile: 3013366588
 * Nombre del proyecto Taller2.
 */
class Empleado {
    private int id;
    private String nombre;
    private int codigo;

    public Empleado() {

    }

    public Empleado(int id, String nombre, int codigo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.nombre + "" + this.codigo + "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
