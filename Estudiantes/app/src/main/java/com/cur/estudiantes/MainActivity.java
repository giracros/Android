package com.cur.estudiantes;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    private EditText carnet;
    private EditText nombre;
    private EditText apellido;
    private EditText nota1;
    private EditText nota2;
    private EditText nota3;

    private EditText definitiva;

    private Button btnAgregar;
    private Button btnListar;
    private Button btnConsultar;
    private Button btnModificar;
    private Button btnEliminar;
    private Button btnCancelar;

    private int estudianteConsultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carnet = (EditText) findViewById(R.id.carnet);
        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        nota1 = (EditText) findViewById(R.id.nota1);
        nota2 = (EditText) findViewById(R.id.nota2);
        nota3 = (EditText) findViewById(R.id.nota3);
        definitiva = (EditText) findViewById(R.id.definitiva);

        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnListar = (Button) findViewById(R.id.btnListar);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnModificar = (Button) findViewById(R.id.btnModificar);
        btnEliminar  = (Button) findViewById(R.id.btnEliminar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        definitiva.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        btnAgregar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                EstudiantesControl db = new EstudiantesControl(MainActivity.this);

                Estudiante estudiante = new Estudiante();
                estudiante.setCarnet(Integer.parseInt(carnet.getText().toString()));
                estudiante.setNombre(nombre.getText().toString());
                estudiante.setApellido(apellido.getText().toString());
                estudiante.setNota1(Double.parseDouble(nota1.getText().toString()));
                estudiante.setNota2(Double.parseDouble(nota2.getText().toString()));
                estudiante.setNota3(Double.parseDouble(nota3.getText().toString()));

                db.agregarEstudiante(estudiante);
                Toast.makeText(MainActivity.this, "Estudiante " + estudiante.getNombre() + " agregado", Toast.LENGTH_LONG).show();

            }
        });


        btnListar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                EstudiantesControl db = new EstudiantesControl(MainActivity.this);
                Intent intent = new Intent(MainActivity.this, Estudiantes.class);
                Bundle bundle = new Bundle();
                ArrayList<Estudiante> estudiantes = db.listarEstudiantes();

                bundle.putSerializable("estudiantes", estudiantes);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btnConsultar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                EstudiantesControl db = new EstudiantesControl(MainActivity.this);
                Estudiante estudiante = new Estudiante();

                estudiante = db.consultarEstudiante(Integer.parseInt(carnet.getText().toString()));
                if (estudiante != null) {
                    estudianteConsultado = estudiante.getId();
                    nombre.setText(estudiante.getNombre());
                    apellido.setText(estudiante.getApellido());
                    nota1.setText(String.valueOf(estudiante.getNota1()));
                    nota2.setText(String.valueOf(estudiante.getNota2()));
                    nota3.setText(String.valueOf(estudiante.getNota3()));


                    definitiva.setText(String.format("%10.1f", estudiante.getDefinitiva()));

                    btnModificar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                }
            }
        });

        btnModificar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                EstudiantesControl db = new EstudiantesControl(MainActivity.this);

                Estudiante estudiante = new Estudiante();
                estudiante.setId(estudianteConsultado);
                estudiante.setCarnet(Integer.parseInt(carnet.getText().toString()));
                estudiante.setNombre(nombre.getText().toString());
                estudiante.setApellido(apellido.getText().toString());
                estudiante.setNota1(Double.parseDouble(nota1.getText().toString()));
                estudiante.setNota2(Double.parseDouble(nota2.getText().toString()));
                estudiante.setNota3(Double.parseDouble(nota3.getText().toString()));

                int e = db.actualizarEstudiante(estudiante);
                if (e != 0)
                    Toast.makeText(MainActivity.this, "Estudiante " + estudiante.getNombre() + " modificado", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Estudiante " + estudiante.getNombre() + " no se pudo modificar!", Toast.LENGTH_LONG).show();
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
            }
        });

        btnEliminar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                EstudiantesControl db = new EstudiantesControl(MainActivity.this);
                int e = db.elminarEstudiante(Integer.parseInt(carnet.getText().toString()));
                if (e != 0)
                    Toast.makeText(MainActivity.this, "El estudiante fue eliminado", Toast.LENGTH_SHORT).show();
                btnEliminar.setEnabled(false);
                btnModificar.setEnabled(false);
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                carnet.setText("");
                nombre.setText("");
                apellido.setText("");
                nota1.setText("");
                nota2.setText("");
                nota3.setText("");
                definitiva.setText("");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
