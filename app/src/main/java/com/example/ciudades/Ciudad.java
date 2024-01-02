package com.example.ciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Ciudad extends AppCompatActivity {

    ImageView imageView;
    TextView textViewCiudad;
    TextView textViewCiudadDescripcion;
    Integer ciudadImgId;
    String ciudadName;
    String ciudadDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad);
        imageView = (ImageView) findViewById(R.id.imageViewBandera);
        textViewCiudad = (TextView) findViewById(R.id.textViewCiudad);
        textViewCiudadDescripcion = (TextView) findViewById(R.id.textViewCiudadDescripcion);
        ciudadImgId = getIntent().getIntExtra("IMAGEN", 0);
        ciudadName = getIntent().getStringExtra("NOMBRE");
        ciudadDesc = getIntent().getStringExtra("DESCRIPCION");
        imageView.setImageResource(ciudadImgId);
        textViewCiudad.setText(ciudadName);
        textViewCiudadDescripcion.setText(ciudadDesc);

    }
}