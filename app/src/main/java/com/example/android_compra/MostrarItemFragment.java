package com.example.android_compra;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.android_compra.databinding.FragmentMostrarItemsBinding;



public class MostrarItemFragment extends Fragment {
    private FragmentMostrarItemsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return (binding = FragmentMostrarItemsBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       ItemsViewM itemsViewM = new ViewModelProvider(requireActivity()).get(ItemsViewM.class);
        itemsViewM.seleccionado().observe(getViewLifecycleOwner(), new Observer<Items>() {
            @Override
            public void onChanged(Items items) {
                binding.nombre.setText(items.nombre);
                binding.descripcion.setText(items.descripcion);

            }
        });

    }


}
