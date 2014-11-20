package com.danielfuentes.taller2.listview_agenda;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.danielfuentes.taller2.R;

import java.util.ArrayList;

/**
 * Nombre del paquete ${PACKAGE_NAME}
 * Creado por danielfuentes en la fecha 11/12/14.
 * Todos los derechos reservados
 * Email: giracros@gmail.com
 * Mobile: 3013366588
 * Nombre del proyecto ${PROJECT_NAME}.
 */
@SuppressWarnings("CanBeFinal")
class AgendaAdapter extends BaseAdapter {

    private ArrayList<Agenda> listadoAgenda;
    private LayoutInflater lytInflater;

    public AgendaAdapter(Context contexto, ArrayList<Agenda> agendas) {
        this.listadoAgenda = agendas;
        this.lytInflater = LayoutInflater.from(contexto);
    }

    @Override
    public int getCount() {
        return listadoAgenda.size();
    }

    @Override
    public Object getItem(int arg0) {
        return listadoAgenda.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        ContenedorView contenedor = null;

        if (arg1 == null) {
            arg1 = lytInflater.inflate(R.layout.lista_agenda_p, null);
            contenedor = new ContenedorView();

            contenedor.fechaPublicacion = (TextView) arg1.findViewById(R.id.lblFecha);
            contenedor.titulo = (TextView) arg1.findViewById(R.id.lblTitulo);
            contenedor.leido = (TextView) arg1.findViewById(R.id.chkLeido);

            arg1.setTag(contenedor);
        } else contenedor = (ContenedorView) arg1.getTag();

        Agenda agenda = (Agenda) getItem(arg0);
        contenedor.fechaPublicacion.setText(agenda.getFechaPublicacion());
        contenedor.titulo.setText(agenda.getTitulo());
        return arg1;
    }

    class ContenedorView {
        TextView fechaPublicacion;
        TextView titulo;
        TextView leido;
    }

}
