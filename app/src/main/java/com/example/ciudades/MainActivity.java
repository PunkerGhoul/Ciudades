package com.example.ciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent i;
    private ListView listView;
    private String arrayTitles[] = new String[]{"Ciudades", "Banderas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.miLista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, arrayTitles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /// Obtiene el valor de la casilla elegida
                String itemSeleccionado = parent.getItemAtPosition(position).toString();
                // muestra un mensaje
                Toast.makeText(getApplicationContext(), "Ha seleccionado " + itemSeleccionado, Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Ha seleccionado " + itemSeleccionado, Toast.LENGTH_SHORT).show();
                    i = new Intent(MainActivity.this, DinamList.class);
                    startActivity(i);
                } else if (position == 1) {
                    Toast.makeText(getApplicationContext(), "Ha seleccionado " + itemSeleccionado, Toast.LENGTH_SHORT).show();
                    i = new Intent(MainActivity.this, StaticListImgs.class);
                    startActivity(i);
                }
            }
        });
    }
}
