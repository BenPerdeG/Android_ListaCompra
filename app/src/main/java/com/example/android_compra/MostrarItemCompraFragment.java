package com.example.android_compra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.android_compra.databinding.FragmentMostrarCompraItemsBinding;

public class MostrarItemCompraFragment extends Fragment {
    private FragmentMostrarCompraItemsBinding binding;

    private NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return (binding = FragmentMostrarCompraItemsBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        ItemsCompraViewM itemsViewM = new ViewModelProvider(requireActivity()).get(ItemsCompraViewM.class);
        itemsViewM.seleccionado().observe(getViewLifecycleOwner(), new Observer<Items>() {
            @Override
            public void onChanged(Items items) {
                binding.nombre.setText(items.nombre);
                binding.descripcion.setText(items.descripcion);

            }
        });
        binding.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemsViewM.eliminar(itemsViewM.seleccionado().getValue());
                navController.navigate(R.id.compraItems);
            }
        });

    }
}