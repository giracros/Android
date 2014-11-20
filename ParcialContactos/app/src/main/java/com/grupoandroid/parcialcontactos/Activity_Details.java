package com.grupoandroid.parcialcontactos;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Activity_Details extends ActionBarActivity {

    private TextView lblCodigo, lblNombreEmpleado, lblHorasTrabajadas, lblValorHora, lblPago;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        lblCodigo = (TextView) findViewById(R.id.txtCode);
        lblNombreEmpleado = (TextView) findViewById(R.id.txtName);
        lblHorasTrabajadas = (TextView) findViewById(R.id.txtHoras);
        lblValorHora = (TextView) findViewById(R.id.txtValorHora);
        lblPago = (TextView) findViewById(R.id.txtPago);

        Bundle Colombianada = getIntent().getExtras();

        lblCodigo.setText(Colombianada.getString("codigo"));
        lblNombreEmpleado.setText(Colombianada.getString("nombre"));
        lblHorasTrabajadas.setText(Colombianada.getString("hora"));
        lblValorHora.setText(Colombianada.getString("valor"));
        lblPago.setText(Colombianada.getString("pago"));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_details, menu);
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
