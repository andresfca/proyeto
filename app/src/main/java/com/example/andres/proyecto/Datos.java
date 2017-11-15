package com.example.andres.proyecto;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by ANDRES on 09/11/2017.
 */

public class Datos {

    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static String bd="Accesorios";
    private static ArrayList<Accesorio>accesorios=new ArrayList<>();
    public static void guardarAccesorio(Accesorio a){
        databaseReference.child(bd).child(a.getId()).setValue(a);
    }
    public static ArrayList<Accesorio>obtenerAccesorio(){
        return accesorios;
    }
    public static void setAccesorios(ArrayList<Accesorio> acc){
        accesorios=acc;
    }
    public static String getId(){
        return databaseReference.push().getKey();
    }
    public static void actualizar(Accesorio a){
        databaseReference.child(bd).child(a.getId()).setValue(a);

    }
    public static void eliminar(Accesorio a){
        databaseReference.child(bd).child(a.getId()).removeValue();
    }
}
