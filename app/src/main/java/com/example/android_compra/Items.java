package com.example.android_compra;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Items {
    @PrimaryKey(autoGenerate = true)
            int id;

    String nombre;
    String descripcion;
    boolean carrito;

    public Items(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.carrito = false;
    }




}