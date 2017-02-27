package com.developer.albert.datospersonales;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    // Variables globales
    Button btnSiguiente;
    TextInputEditText edtNombreCompleto;
    TextInputEditText edtTelefono;
    TextInputEditText edtEmail;
    TextInputEditText edtDescripcionContacto;

    DatePicker dpFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();

        try {
            Bundle parametros = getIntent().getExtras();
            edtNombreCompleto.setText(parametros.getString(getResources().getString(R.string.extra_nombre_completo)));
            edtTelefono.setText(parametros.getString(getResources().getString(R.string.extra_telefono)));
            edtEmail.setText(parametros.getString(getResources().getString(R.string.extra_email)));
            edtDescripcionContacto.setText(parametros.getString(getResources().getString(R.string.extra_descripcion)));
            String day=parametros.getString(getResources().getString(R.string.extra_dia));
            String month=parametros.getString(getResources().getString(R.string.extra_mes));
            String year=parametros.getString(getResources().getString(R.string.extra_anio));
            dpFecha.init(Integer.parseInt(year),Integer.parseInt(month)-1,Integer.parseInt(day),null);

        }
        catch (Exception e)
        {}

    }

    public void InicializarControles(){
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        edtNombreCompleto = (TextInputEditText) findViewById(R.id.edtNombreCompleto);
        edtTelefono = (TextInputEditText) findViewById(R.id.edtTelefono);
        edtEmail = (TextInputEditText) findViewById(R.id.edtEmail);
        edtDescripcionContacto = (TextInputEditText) findViewById(R.id.edtDescripcionContacto);
        dpFecha = (DatePicker) findViewById(R.id.dpFecha);

    }

    public void ConfirmarDatos(View view){
        int day=dpFecha.getDayOfMonth();
        int month=dpFecha.getMonth()+1; ///here i added +1 in month..
        int year=dpFecha.getYear();

        Intent intent = new Intent(MainActivity.this,ConfirmacionDatos.class);
        intent.putExtra(getResources().getString(R.string.extra_nombre_completo),edtNombreCompleto.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_telefono),edtTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_email),edtEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_descripcion),edtDescripcionContacto.getText().toString());
        //intent.putExtra(getResources().getString(R.string.extra_fecha),new Date(dpFecha.getYear(), dpFecha.getMonth(), dpFecha.getDayOfMonth()));
        intent.putExtra(getResources().getString(R.string.extra_anio),year + "");
        intent.putExtra(getResources().getString(R.string.extra_mes),right(("0"+month+ ""),2));
        intent.putExtra(getResources().getString(R.string.extra_dia),right(("0"+day+ ""),2));

        startActivity(intent);

    }
    public static String right(String value, int length) {
        // To get right characters from a string, change the begin index.
        return value.substring(value.length() - length);
    }
}
