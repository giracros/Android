package com.grupoandroid.parcialcontactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Activity_Contactos extends ActionBarActivity {

    protected static final int REQUEST_CODE = 1;
    Empleado empleados[];
    private TextView nro;
    private TextView codempleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        final ListView lstEmpleados = (ListView) findViewById(R.id.lstEmpleados);

        empleados = new Empleado[]{
                new Empleado(1, "Johe Caicedo", 48, 30000),
                new Empleado(2, "Daniel Fuentes", 45, 30000),
                new Empleado(3, "MisiJaguar", 50, 34000),
                new Empleado(4, "Michael Jordan", 60, 34000),
                new Empleado(5, "Missiy Elliot", 40, 45000),
                new Empleado(6, "Camilo Mendoza", 12, 5600),
                new Empleado(7, "Obama", 12, 5600),
                new Empleado(8, "Eminem", 12, 5600),
                new Empleado(9, "Los Visconti", 12, 5600),
                new Empleado(10, "Alvaro Meneses", 12, 5600),
        };

        ArrayAdapter<Empleado> adapterempleado = new ArrayAdapter<Empleado>(this, android.R.layout.simple_list_item_1, empleados);

        lstEmpleados.setAdapter(adapterempleado);

        lstEmpleados.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Empleado empleado = (Empleado) Array.get(empleados, position);

                Intent i = new Intent(Activity_Contactos.this, Activity_Details.class);
                i.putExtra("codigo", Integer.toString(empleado.getCodEmpleado()));
                i.putExtra("nombre", empleado.getNomEmpleado());
                i.putExtra("hora", Integer.toString(empleado.getNumHorasSemana()));
                i.putExtra("valor", Double.toString(empleado.getValorHora()));
                i.putExtra("pago", Double.toString(empleado.getPago()));
                startActivityForResult(i, REQUEST_CODE);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_contactos, menu);
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
