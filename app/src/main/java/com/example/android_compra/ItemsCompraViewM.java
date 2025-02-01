package com.example.android_compra;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class ItemsCompraViewM extends AndroidViewModel {

    ItemsRepo itempsrepo;


    static MutableLiveData<Items> ItemsSeleccionado = new MutableLiveData<>();
    public ItemsCompraViewM(@NonNull Application application) {
        super(application);

        itempsrepo = new ItemsRepo(application);


    }

    LiveData<List<Items>> obtener(){
        return itempsrepo.obtenerCOMPRA();
    }

    void insertar(Items items) {
        itempsrepo.actualizar(items);
    }

    void eliminar(Items items) {
       itempsrepo.eliminar(items);
    }

    void seleccionar(Items items) {
        ItemsSeleccionado.setValue(items);
    }

    void actualizar(Items items){
        itempsrepo.devolver(items);
    }
    static MutableLiveData<Items> seleccionado() {
        return ItemsSeleccionado;
    }
}
