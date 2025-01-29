package com.example.android_compra;

import java.util.ArrayList;
import java.util.List;

public class ItemsRepo {

    List<Items> items = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Items> items);
    }

    ItemsRepo() {
        items.add(new Items("Piña", "Una piña. ¿Bajo el mar? NO"));
        items.add(new Items("Naranja", "El color no la fruta. Bote de pintura"));
        items.add(new Items("Kebab", "mmmmmmhhhmhmh Kebaaaab..."));

    }

    List<Items> obtener() {
        return items;
    }

    void insertar(Items items, Callback callback) {
        this.items.add(items);
        callback.cuandoFinalice(this.items);
    }

    void eliminar(Items items, Callback callback) {
        this.items.remove(items);
        callback.cuandoFinalice(this.items);
    }

    void actualizar(Items items, String cantidad, Callback callback) {
        callback.cuandoFinalice(this.items);
    }
}


////////////Segundo Repo

class ItemsCompraRepo{
    List<Items> itemsCompra = new ArrayList<>();

    interface Callback {
        void cuandoFinaliceCompra(List<Items> itemsCompra);
    }

    ItemsCompraRepo(){
        itemsCompra.add(new Items("Piñañññ","Una piña. ¿Bajo el mar? NO"));
        itemsCompra.add(new Items("Naranja","El color no la fruta. Bote de pintura"));
        itemsCompra.add(new Items("Kebab","mmmmmmhhhmhmh Kebaaaab..."));

    }

    List<Items> obtenerCOMPRA() {
        return itemsCompra;
    }

    void insertarCOMPRA(Items items, Callback callback){
        this.itemsCompra.add(items);
        callback.cuandoFinaliceCompra(this.itemsCompra);
    }

    void eliminarCOMPRA(Items items, Callback callback) {
        this.itemsCompra.remove(items);
        callback.cuandoFinaliceCompra(this.itemsCompra);
    }

    void actualizarCOMPRA(Items items, String cantidad, Callback callback) {
        callback.cuandoFinaliceCompra(this.itemsCompra);
    }
}