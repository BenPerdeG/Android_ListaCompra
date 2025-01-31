package com.example.android_compra;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ItemsViewM extends AndroidViewModel {

    ItemsRepo itempsrepo;



    MutableLiveData<Items> ItemsSeleccionado = new MutableLiveData<>();
    public ItemsViewM(@NonNull Application application) {
        super(application);



        itempsrepo = new ItemsRepo(application);
    }

    LiveData<List<Items>> obtener(){
        return itempsrepo.obtener();
    }

    void insertar(Items items){
        itempsrepo.insertar(items);
    }

    void eliminar(Items items){
       itempsrepo.eliminar(items);
    }

    void actualizar(Items items){
        itempsrepo.actualizar(items);
    }
    void seleccionar(Items items){
        ItemsSeleccionado.setValue(items);
    }

    MutableLiveData<Items> seleccionado(){
        return ItemsSeleccionado;
    }
}

