package com.example.android_compra;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_compra.databinding.FragmentRecyclerItemsBinding;
import com.example.android_compra.databinding.ViewholderItemBinding;

import java.util.List;

public class RecyclerItemsFragment extends Fragment {

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderItemBinding binding;

        public ItemViewHolder(ViewholderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class ItemssAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        List<Items> items;

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemViewHolder(ViewholderItemBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

            Items items = this.items.get(position);

            holder.binding.nombre.setText(items.nombre);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemsViewM.seleccionar(items);
                    navController.navigate(R.id.action_recyclerItemsFragment_to_mostrarItemFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return items != null ? items.size() : 0;
        }

        public void establecerLista(List<Items> items){
            this.items = items;
            notifyDataSetChanged();
        }

        public Items obtenerItems(int posicion){
            return items.get(posicion);
        }
    }


    private FragmentRecyclerItemsBinding binding;
    private ItemsViewM itemsViewM;
    private NavController navController;
    private ItemsCompraViewM itemsCompraViewM;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentRecyclerItemsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemsViewM = new ViewModelProvider(requireActivity()).get(ItemsViewM.class);
        itemsCompraViewM = new ViewModelProvider(requireActivity()).get(ItemsCompraViewM.class);
        navController = Navigation.findNavController(view);

        binding.irANuevoElemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_recyclerItemsFragment_to_nuevoItemFragment);
            }
        });
        ItemssAdapter itemssAdapter = new ItemssAdapter();
        binding.recyclerView.setAdapter(itemssAdapter);

        itemsViewM.obtener().observe(getViewLifecycleOwner(), new Observer<List<Items>>() {
            @Override
            public void onChanged(List<Items> items) {
                itemssAdapter.establecerLista(items);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.RIGHT  | ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int posicion = viewHolder.getAdapterPosition();
                Items items = itemssAdapter.obtenerItems(posicion);
                itemsCompraViewM.insertar(items);
                itemsViewM.actualizar(items);
                itemsViewM.obtener();

            }
        }).attachToRecyclerView(binding.recyclerView);
    }
}
