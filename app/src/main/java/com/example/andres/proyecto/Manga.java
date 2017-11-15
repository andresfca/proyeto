package com.example.andres.proyecto;

/**
 * Created by ANDRES on 09/11/2017.
 */

public class Manga {
    private String id;
    private String genero;
    private String nombre;
    private String precio;

    public Manga() {
    }

    public Manga(String genero, String nombre, String precio) {
        this.genero = genero;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Manga(String id, String genero, String nombre, String precio) {
        this.id = id;
        this.genero = genero;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

}
