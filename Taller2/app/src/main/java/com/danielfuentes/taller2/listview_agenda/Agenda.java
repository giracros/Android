package com.danielfuentes.taller2.listview_agenda;

/**
 * Nombre del paquete ${PACKAGE_NAME}
 * Creado por danielfuentes en la fecha 11/12/14.
 * Todos los derechos reservados
 * Contacto giracros@gmail.com
 * Nombre del proyecto ${PROJECT_NAME}.
 */
@SuppressWarnings("ALL")
class Agenda {

    private String fechaPublicacion;
    private String titulo;
    private boolean leido; // el checkbox

    public Agenda(String fechaPublicacion, String titulo) {
        this.fechaPublicacion = fechaPublicacion;
        this.titulo = titulo;
        this.leido = leido;
    }


    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
}
