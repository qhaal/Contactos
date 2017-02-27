package com.developer.albert.datospersonales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class ConfirmacionDatos extends AppCompatActivity {

    TextView txtNombreCompleto;
    TextView txtFechaNacimiento;
    TextView txtTelefono;
    TextView txtEmail;
    TextView txtDescripcion;
    Button btnEditar;
    Date Fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

        InicializarControles();

        Bundle parametros = getIntent().getExtras();
        txtNombreCompleto.setText(parametros.getString(getResources().getString(R.string.extra_nombre_completo)));
        txtTelefono.setText(parametros.getString(getResources().getString(R.string.extra_telefono)));
        txtEmail.setText(parametros.getString(getResources().getString(R.string.extra_email)));
        txtDescripcion.setText(parametros.getString(getResources().getString(R.string.extra_descripcion)));
        //txtFechaNacimiento.setText(parametros.getString(getResources().getString(R.string.extra_fecha)));
        txtFechaNacimiento.setText(parametros.getString(getResources().getString(R.string.extra_dia))+ "/"+
                parametros.getString(getResources().getString(R.string.extra_mes)) + "/"+
                parametros.getString(getResources().getString(R.string.extra_anio)));




    }
    public void InicializarControles(){
        txtNombreCompleto = (TextView) findViewById(R.id.txtNombreCompleto);
        txtFechaNacimiento = (TextView) findViewById(R.id.txtFechaNacimiento);
        txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        btnEditar = (Button) findViewById(R.id.btnEditar);
    }

    public void EditarDatos(View view){
        Intent intent = new Intent(ConfirmacionDatos.this,MainActivity.class);
        intent.putExtra(getResources().getString(R.string.extra_nombre_completo),txtNombreCompleto.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_telefono),txtTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_email),txtEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_descripcion),txtDescripcion.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_anio),txtFechaNacimiento.getText().toString().substring(6,10));
        intent.putExtra(getResources().getString(R.string.extra_mes),txtFechaNacimiento.getText().toString().substring(3,5));
        intent.putExtra(getResources().getString(R.string.extra_dia),txtFechaNacimiento.getText().toString().substring(0,2));

        startActivity(intent);

    }
}
