package com.example.android_compra;

public class Items {
    String nombre;
    String descripcion;
    String cantidad;

    public Items(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = "0";
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }


}