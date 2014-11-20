package com.danielfuentes.taller2.listview_agenda;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.danielfuentes.taller2.R;

import java.util.ArrayList;

public class lista_agenda extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_agenda);
        ListView lstAgenda = (ListView) findViewById(R.id.lstAgenda);
        ArrayList<Agenda> agendas = new ArrayList<Agenda>();
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        agendas.add(new Agenda("21/11/2014", "Reunion con el gerente de bancolombia"));
        AgendaAdapter adpAgendas = new AgendaAdapter(lista_agenda.this, agendas);
        lstAgenda.setAdapter(adpAgendas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_agenda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}