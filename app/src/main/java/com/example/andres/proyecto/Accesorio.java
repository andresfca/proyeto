package com.example.andres.proyecto;

public class Accesorio {
    private String id;
    private String tipo;
    private String nombre;
    private double precio;
    private String foto;

    public Accesorio(){

    }

    public Accesorio(String id, String tipo, String nombre, double precio, String foto) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
        this.foto = foto;
    }
    public Accesorio(String id, String tipo, String nombre, double precio) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Accesorio(String tipo, String nombre, double precio) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdd() {
        return nombre.hashCode();
    }

    /*public static Accesorio[] ITEMS = {
            new Accesorio("1","colg","collarKTH",2000, R.drawable.fotoacc),
            new Accesorio("2","colga","collarKT",200, R.drawable.fotomang),
            new Accesorio("3","colgante","collar",20000, R.drawable.fotojueg),

    };*/
    /*public static Accesorio getItem(int id){
        for (Accesorio item:ITEMS){
            if (item.getIdd()==id){
                return item;
            }
        }
        return null;
    }*/
    public void guardar(){
        Datos.guardarAccesorio(this);
    }
}
