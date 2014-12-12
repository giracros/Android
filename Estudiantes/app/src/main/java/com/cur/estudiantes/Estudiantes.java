package com.cur.estudiantes;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Nombre del paquete com.cur.estudiantes
 * Creado por danielfuentes en la fecha 12/11/14.
 * Todos los derechos reservados
 * Email: giracros@gmail.com
 * Mobile: 3013366588
 * Nombre del proyecto Estudiantes.
 */
public class Estudiantes extends Activity {

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

        btnRegresar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}