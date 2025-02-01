package com.example.android_compra;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ItemsRepo {
    ItemsBaseDeDatos.ItemsDao elementosDao;

    ItemsRepo(Application application){
        elementosDao = ItemsBaseDeDatos.obtenerInstancia(application).obtenerItemsDao();
    }
    Executor executor = Executors.newSingleThreadExecutor();

    LiveData<List<Items>> obtener() {
        return elementosDao.obtener();
    }

    LiveData<List<Items>> obtenerCOMPRA() {
        return elementosDao.obtenerCompra();
    }

    void insertar(Items items) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementosDao.insertar(items);
            }
        });
    }

    void eliminar(Items items) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementosDao.eliminar(items);
            }
        });
    }

    void actualizar(Items items) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                items.carrito=true;
                elementosDao.actualizar(items);
            }
        });
    }
    void devolver(Items items) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                items.carrito=false;
                elementosDao.actualizar(items);
            }
        });
    }
}


