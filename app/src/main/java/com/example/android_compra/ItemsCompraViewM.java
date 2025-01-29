package com.example.android_compra;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ItemsCompraViewM extends AndroidViewModel {

    ItemsCompraRepo itempsrepo;

    MutableLiveData<List<Items>> listItemsMutableLiveData = new MutableLiveData<>();
    static MutableLiveData<Items> ItemsSeleccionado = new MutableLiveData<>();
    public ItemsCompraViewM(@NonNull Application application) {
        super(application);

        itempsrepo = new ItemsCompraRepo();

        listItemsMutableLiveData.setValue(itempsrepo.obtenerCOMPRA());
    }

    MutableLiveData<List<Items>> obtener() {
        return listItemsMutableLiveData;
    }

    void insertar(Items items) {
        itempsrepo.insertarCOMPRA(items, new ItemsCompraRepo.Callback() {
            @Override
            public void cuandoFinaliceCompra(List<Items> items) {
                listItemsMutableLiveData.setValue(items);
            }
        });
    }

    void eliminar(Items items) {
        itempsrepo.eliminarCOMPRA(items, new ItemsCompraRepo.Callback() {
            @Override
            public void cuandoFinaliceCompra(List<Items> items) {
                listItemsMutableLiveData.setValue(items);
            }
        });
    }

    void actualizar(Items items, String cantidad) {
        itempsrepo.actualizarCOMPRA(items, cantidad, new ItemsCompraRepo.Callback() {
            @Override
            public void cuandoFinaliceCompra(List<Items> items) {
                listItemsMutableLiveData.setValue(items);
            }
        });
    }

    void seleccionar(Items items) {
        ItemsSeleccionado.setValue(items);
    }

    static MutableLiveData<Items> seleccionado() {
        return ItemsSeleccionado;
    }
}
