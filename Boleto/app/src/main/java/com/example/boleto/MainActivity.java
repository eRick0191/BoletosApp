package com.example.boleto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText fechaOb;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Boleto bol = new Boleto();
        fechaOb = (EditText) findViewById(R.id.fechaOb);
        fechaOb.setOnClickListener(this);
        EditText nombreEdit= (EditText) findViewById(R.id.nombreOb);
        EditText edadEdit= (EditText) findViewById(R.id.edadOb);
        EditText boletoEdit= (EditText) findViewById(R.id.numeroBoletoOb);
        EditText  precioEdit= (EditText) findViewById(R.id.precioOb);
        Button btnViaje= (Button) findViewById(R.id.btnMostrar);
        Button btnRegresar= (Button) findViewById(R.id.btnLimpiar);
        Spinner spnDestino =(Spinner) findViewById(R.id.spnDestino);
        Spinner spnTipo =(Spinner) findViewById(R.id.spnTipo);
        TextView nombreL = (TextView) findViewById(R.id.nombreUnoLb);
        TextView edadL = (TextView) findViewById(R.id.edadUnoLb);
        TextView boletoL = (TextView) findViewById(R.id.numeroBoletoUnoLb);
        TextView destinoL = (TextView) findViewById(R.id.destinoUnoLb);
        TextView tipoL = (TextView) findViewById(R.id.tipoUnoLb);
        TextView precioL = (TextView) findViewById(R.id.precioUnoLb);
        TextView fechaL = (TextView) findViewById(R.id.fechaUnoLb);
        TextView subLb = (TextView) findViewById(R.id.subLb);
        TextView  totalLb = (TextView) findViewById(R.id.totalLb);
        TextView impLb = (TextView) findViewById(R.id.impLb);
        TextView desLb = (TextView) findViewById(R.id.desLb);
        btnRegresar.setVisibility(View.INVISIBLE);
        btnViaje.setOnClickListener(v -> {
            if(fechaOb.getText().toString().matches("") || nombreEdit.getText().toString().matches("") || edadEdit.getText().toString().matches("") ||
                    boletoEdit.getText().toString().matches("") || precioEdit.getText().toString().matches("")){
                Toast.makeText(MainActivity.this,"Favor de rellenar todos los espacios",Toast.LENGTH_SHORT).show();
            }else{

                bol.setFecha(fechaOb.getText().toString());
                bol.setId(Integer.parseInt(boletoEdit.getText().toString()));
                bol.setNombre(nombreEdit.getText().toString());
                bol.setPrecio(Double.parseDouble(precioEdit.getText().toString()));

                fechaOb.setVisibility(View.INVISIBLE);
                nombreEdit.setVisibility(View.INVISIBLE);
                boletoEdit.setVisibility(View.INVISIBLE);
                edadEdit.setVisibility(View.INVISIBLE);
                precioEdit.setVisibility(View.INVISIBLE);
                spnDestino.setVisibility(View.INVISIBLE);
                spnTipo.setVisibility(View.INVISIBLE);
                precioL.setVisibility(View.INVISIBLE);
                nombreL.setText("Nombre: "+bol.getNombre());
                edadL.setText("Edad: "+ Integer.parseInt(edadEdit.getText().toString()));
                boletoL.setText("No. boleto: "+bol.getId());
                destinoL.setText("Destino: "+bol.getDestino());
                tipoL.setText("Tipo de viaje: "+bol.getTipo());
                fechaL.setText("Fecha: "+bol.getFecha());
                subLb.setText("Subtotal: "+bol.obtenerSubtotal());
                totalLb.setText("Total: "+(bol.obtenerTotal()-bol.obtenerDescuento(Integer.parseInt(edadEdit.getText().toString()))));
                impLb.setText("Impuesto: "+bol.obtenerIVA());
                desLb.setText("Descuento: "+bol.obtenerDescuento(Integer.parseInt(edadEdit.getText().toString())));
                edadL.setTranslationY(-130);
                boletoL.setTranslationY(-220);
                destinoL.setTranslationY(-345);
                tipoL.setTranslationY(-500);
                precioL.setTranslationY(-910);
                fechaL.setTranslationY(-850);
                subLb.setTranslationY(-980);
                totalLb.setTranslationY(-980);
                impLb.setTranslationY(-980);
                desLb.setTranslationY(-980);
                btnViaje.setVisibility(View.INVISIBLE);
                btnRegresar.setVisibility(View.VISIBLE);
                fechaOb.setText("");
                nombreEdit.setText("");
                edadEdit.setText("");
                boletoEdit.setText("");
                precioEdit.setText("");
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edadL.setTranslationY(0);
                boletoL.setTranslationY(0);
                destinoL.setTranslationY(0);
                tipoL.setTranslationY(0);
                precioL.setTranslationY(0);
                fechaL.setTranslationY(0);
                subLb.setTranslationY(0);
                totalLb.setTranslationY(0);
                impLb.setTranslationY(0);
                desLb.setTranslationY(0);
                nombreL.setText("Nombre: ");
                edadL.setText("Edad: ");
                boletoL.setText("Numero de boleto: ");
                destinoL.setText("Destino: ");
                tipoL.setText("Tipo de viaje: ");
                precioL.setText("Precio: ");
                fechaL.setText("Fecha: ");
                subLb.setText("");
                totalLb.setText("");
                impLb.setText("");
                desLb.setText("");
                btnViaje.setVisibility(View.VISIBLE);
                btnRegresar.setVisibility(View.INVISIBLE);
                fechaOb.setVisibility(View.VISIBLE);
                nombreEdit.setVisibility(View.VISIBLE);
                boletoEdit.setVisibility(View.VISIBLE);
                edadEdit.setVisibility(View.VISIBLE);
                precioEdit.setVisibility(View.VISIBLE);
                spnDestino.setVisibility(View.VISIBLE);
                spnTipo.setVisibility(View.VISIBLE);
            }
        });
        ArrayAdapter<String> Adaptador =new
                ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.destinos));
        ArrayAdapter<String> Adaptador2 =new
                ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.tiposBoleto));
        spnDestino.setAdapter(Adaptador);
        spnTipo.setAdapter(Adaptador2);
        spnDestino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                bol.setDestino(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
        spnTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                bol.setTipo(Integer.parseInt(adapterView.getItemAtPosition(i).toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }


    @Override
    public void onClick(View v) {
        int dia,mes,año;
        final Calendar c= Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        año=c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                fechaOb.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },dia,mes,año);
        datePickerDialog.show();
    }



}