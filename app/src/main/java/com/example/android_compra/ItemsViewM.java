package com.example.android_compra;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ItemsViewM extends AndroidViewModel {

    ItemsRepo itempsrepo;

    MutableLiveData<List<Items>> listItemsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Items> ItemsSeleccionado = new MutableLiveData<>();
    public ItemsViewM(@NonNull Application application) {
        super(application);

        itempsrepo = new ItemsRepo();

        listItemsMutableLiveData.setValue(itempsrepo.obtener());
    }

    MutableLiveData<List<Items>> obtener(){
        return listItemsMutableLiveData;
    }

    void insertar(Items items){
        itempsrepo.insertar(items, new ItemsRepo.Callback(){
            @Override
            public void cuandoFinalice(List<Items> items) {
                listItemsMutableLiveData.setValue(items);
            }
        });
    }

    void eliminar(Items items){
        itempsrepo.eliminar(items, new ItemsRepo.Callback(){
            @Override
            public void cuandoFinalice(List<Items> items) {
                listItemsMutableLiveData.setValue(items);
            }
        });
    }

    void actualizar(Items items, String cantidad){
        itempsrepo.actualizar(items, cantidad, new ItemsRepo.Callback() {
            @Override
            public void cuandoFinalice(List<Items> items) {
                listItemsMutableLiveData.setValue(items);
            }
        });
    }
    void seleccionar(Items items){
        ItemsSeleccionado.setValue(items);
    }

    MutableLiveData<Items> seleccionado(){
        return ItemsSeleccionado;
    }
}

class ItemsCompraViewM extends AndroidViewModel {

    ItemsCompraRepo itempsrepo;

    MutableLiveData<List<Items>> listItemsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Items> ItemsSeleccionado = new MutableLiveData<>();
    public ItemsCompraViewM(@NonNull Application application) {
        super(application);

        itempsrepo = new ItemsCompraRepo();

        listItemsMutableLiveData.setValue(itempsrepo.obtenerCOMPRA());
    }

    MutableLiveData<List<Items>> obtener(){
        return listItemsMutableLiveData;
    }

    void insertar(Items items){
        itempsrepo.insertarCOMPRA(items, new ItemsCompraRepo.Callback(){
            @Override
            public void cuandoFinaliceCompra(List<Items> items) {
                listItemsMutableLiveData.setValue(items);
            }
        });
    }

    void eliminar(Items items){
        itempsrepo.eliminarCOMPRA(items, new ItemsCompraRepo.Callback(){
            @Override
            public void cuandoFinaliceCompra(List<Items> items) {
                listItemsMutableLiveData.setValue(items);
            }
        });
    }

    void actualizar(Items items, String cantidad){
        itempsrepo.actualizarCOMPRA(items, cantidad, new ItemsCompraRepo.Callback() {
            @Override
            public void cuandoFinaliceCompra(List<Items> items) {
                listItemsMutableLiveData.setValue(items);
            }
        });
    }
    void seleccionar(Items items){
        ItemsSeleccionado.setValue(items);
    }

    MutableLiveData<Items> seleccionado(){
        return ItemsSeleccionado;
    }
}
