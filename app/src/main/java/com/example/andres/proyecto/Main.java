package com.example.andres.proyecto;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main extends Activity {
    private Resources resources;
    private String opc[] = new String[]{"Accesorios","Juegos","Mangas"};
    private Integer[] img={R.drawable.fotoacc,R.drawable.fotojueg,R.drawable.fotomang};
    private ListView lista;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Tienda virtual Shiroe");
        //resources = this.getResources();
        //opc = resources.getStringArray(R.array.arrayOpc);

        adaptadorProducto adaptadorProducto = new adaptadorProducto(this, opc, img);
        lista = (ListView)findViewById(R.id.lstProducto);
        lista.setAdapter(adaptadorProducto);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent=new Intent(Main.this,AgregarAccesorio.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(Main.this,AgregarJuego.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent=new Intent(Main.this,AgregarManga.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
