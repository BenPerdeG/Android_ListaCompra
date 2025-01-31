package com.example.android_compra;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;

@Database(entities = {Items.class}, version = 1, exportSchema = false)
public abstract class ItemsBaseDeDatos extends RoomDatabase {

    private static volatile ItemsBaseDeDatos INSTANCIA;
    public abstract ItemsDao obtenerItemsDao();
    static ItemsBaseDeDatos obtenerInstancia(final Context context) {
        if (INSTANCIA == null) {
            synchronized (ItemsBaseDeDatos.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context,
                                    ItemsBaseDeDatos.class, "elementos.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCIA;
    }
    @Dao
    interface ItemsDao {
        @Query("Select * from Items where carrito=0")
        LiveData<List<Items>> obtener();

        @Query("Select * from Items where carrito=1")
        LiveData<List<Items>> obtenerCompra();

        @Insert
        void insertar(Items elemento);

        @Update
        void actualizar(Items elemento);

        @Delete
        void eliminar(Items elemento);



    }


}