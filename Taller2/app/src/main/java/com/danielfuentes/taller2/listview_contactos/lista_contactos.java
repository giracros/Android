package com.danielfuentes.taller2.listview_contactos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.danielfuentes.taller2.R;

public class lista_contactos extends Activity {

    private TextView nro;
    private TextView codempleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_contactos);

        codempleado = (TextView) findViewById(R.id.lblCodigoEmp);
        nro = (TextView) findViewById(R.id.lblNroItem);

        ListView lstEmpleados = (ListView) findViewById(R.id.lstEmpleados);

        Empleado empleados[] = {
                new Empleado(1, "Presidente", 469138),
                new Empleado(2, "Vicepresidente", 898781),
                new Empleado(3, "Director", 987634),
                new Empleado(4, "Gerente General", 109873),
                new Empleado(5, "Gerente de Proyecto", 198465),
                new Empleado(6, "Lider de Proyecto", 987532),
        };

        ArrayAdapter<Empleado> adapterempleado = new ArrayAdapter<Empleado>(this, android.R.layout.simple_list_item_1, empleados);

        lstEmpleados.setAdapter(adapterempleado);

        lstEmpleados.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item1 = ((TextView) view).getText().toString();
                codempleado.setText(item1);
                nro.setText("Posicion en la Lista: " + position);
            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_contactos, menu);
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
