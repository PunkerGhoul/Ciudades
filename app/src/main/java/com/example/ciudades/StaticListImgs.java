package com.example.ciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class StaticListImgs extends AppCompatActivity {

    Intent i;
    private ListView lista; //Arreglo crea los elementos de la lista
    private String lista_imagen[] = new String[]{"Bogotá", "Sogamoso", "Medellín"};
    //Arreglo Asigna imagenes a la lista
    private Integer[] imgid = {R.drawable.flag_of_bogota, R.drawable.flag_of_sogamoso, R.drawable.flag_of_medellin};
    private String[] descid = {"Cundinamarca es uno de los 32 departamentos que, junto con Bogotá, Distrito Capital, forman la República de Colombia. Su capital es Bogotá, la capital del país, está ubicado en el centro del país.", "Sogamoso es un municipio colombiano situado en el centro-oriente del departamento de Boyacá en la región del Alto Chicamocha, es la capital de la Provincia de Sugamuxi.", "Antioquia es un departamento de la República de Colombia, localizado al noroeste del país y compuesto por 125 municipios, agrupados en nueve subregiones, su capital es Medellín, la segunda ciudad más importante del país."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_list_imgs);

        AdministradorListAdapter adapter = new AdministradorListAdapter(this, lista_imagen, imgid);
        lista = (ListView) findViewById(R.id.mi_lista);
        lista.setAdapter((ListAdapter) adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = lista_imagen[+position];
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Ha seleccionado " + selectedItem, Toast.LENGTH_SHORT).show();
                i = new Intent(StaticListImgs.this, Ciudad.class);
                i.putExtra("IMAGEN", imgid[+position]);
                i.putExtra("NOMBRE", selectedItem);
                i.putExtra("DESCRIPCION", descid[+position]);
                startActivity(i);
            }
        });
    }
}