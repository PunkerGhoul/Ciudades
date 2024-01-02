package com.example.ciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class DinamList extends AppCompatActivity {

    RequestQueue requestQueue;
    ListView lista;
    String nombre;
    String IP = "192.168.183.75";
    String[] elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinam_list);

        requestQueue = Volley.newRequestQueue(this);
        lista = (ListView) findViewById(R.id.lvLista);
        ejecutarURL();
    }

    public void ejecutarURL() {
        listarCiudades("http://" + IP + "/practicaMovil/listar_ciudades.php?filter=nombre");
    }

    public void mostrar() {
        ArrayAdapter<String> adapter = new ArrayAdapter(DinamList.this, android.R.layout.simple_list_item_1, elementos);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Al hacer click en cualquiera de los elementos de la lista
            }
        });
    }

    void listarCiudades(String url) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, response -> {
            JSONObject jsonObject;
            elementos = new String[response.length()];
            for (int i = 0; i < response.length(); i++) {
                try {
                    jsonObject = response.getJSONObject(i);
                    nombre = jsonObject.getString("nombre");
                    elementos[i] = nombre;
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            mostrar();
        }, error -> Toast.makeText(getApplicationContext(), "ERROR DE CONEXION", Toast.LENGTH_SHORT).show());
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}