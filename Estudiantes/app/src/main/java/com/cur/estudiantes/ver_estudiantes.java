package com.cur.estudiantes;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ver_estudiantes extends ActionBarActivity {

    private ListView lista;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_estudiantes);

        lista = (ListView) findViewById(R.id.lista);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        ArrayList<Estudiante> estudiantes = (ArrayList<Estudiante>) getIntent().getSerializableExtra("estudiantes");
        ArrayAdapter<Estudiante> adpEstudiante = new ArrayAdapter<Estudiante>(this, android.R.layout.simple_list_item_1, estudiantes);
        lista.setAdapter(adpEstudiante);

        btnRegresar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ver_estudiantes, menu);
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
