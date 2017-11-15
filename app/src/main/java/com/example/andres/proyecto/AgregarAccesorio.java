package com.example.andres.proyecto;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class AgregarAccesorio extends AppCompatActivity {
    private GridView listado;
    private ArrayList<Accesorio> accesorios;
    private Resources resources;
    private AdaptadorAccesorio adaptadorAccesorio;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private final String BD="Accesorios";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_accesorio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Agregar Accesorios");

        listado=(GridView)findViewById(R.id.grtAccesorio);
        //adaptadorAccesorio = new AdaptadorAccesorio(this);
        //listado.setAdapter(adaptadorAccesorio);
        //listado.setOnItemClickListener(this);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void agregar(View v){
        Intent i = new Intent(AgregarAccesorio.this,CrearAccesorio.class);
        startActivity(i);
    }


}
