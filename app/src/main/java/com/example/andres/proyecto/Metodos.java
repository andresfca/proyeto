package com.example.andres.proyecto;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ANDRES on 15/11/2017.
 */

public class Metodos {
    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return fotos.get(fotoSeleccionada);
    }
    public  static boolean validar_aux(TextView t, String mensaje){
        if (t.getText().toString().isEmpty()){
            t.requestFocus();
            t.setError(mensaje);
            return true;
        }
        return false;
    }
    public static boolean existencia_Accesorio(ArrayList<Accesorio> accesorios, String nombre){
        for (int i = 0; i < accesorios.size(); i++) {
            if (accesorios.get(i).getNombre().equalsIgnoreCase(nombre)) return true;
        }
        return false;
    }
}
