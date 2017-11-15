package com.example.andres.proyecto;

import java.util.ArrayList;

/**
 * Created by Redes on 10/11/2017.
 */

public class Producto {
    private int foto;
    private String prtNombre;

    public Producto(int foto, String prtNombre) {
        this.foto = foto;
        this.prtNombre = prtNombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getPrtNombre() {
        return prtNombre;
    }

    public void setPrtNombre(String prtNombre) {
        this.prtNombre = prtNombre;
    }
   /* public void guardar(){
        Datos.guardarProducto(this);
    }*/
}
