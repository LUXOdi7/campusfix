package com.example.campusfix.adaptador;

import static android.app.ProgressDialog.show;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusfix.databinding.ItemTipoIncidenciaBinding;
import com.example.campusfix.modelo.TipoIncidencia;

import java.util.ArrayList;

public class TipoIncidenciaAdaptador extends RecyclerView.Adapter<TipoIncidenciaAdaptador.ViewHolder> {
    private ArrayList<TipoIncidencia> listaTipoIncidencia;
    public TipoIncidenciaAdaptador(ArrayList<TipoIncidencia> listaTipoIncidencia) {
        this.listaTipoIncidencia = listaTipoIncidencia;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTipoIncidenciaBinding binding = ItemTipoIncidenciaBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    public void actualizarLista(ArrayList<TipoIncidencia> nuevaLista) {
        this.listaTipoIncidencia = nuevaLista;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TipoIncidencia tipoIncidencia = listaTipoIncidencia.get(position);
        holder.mostrarDatos(tipoIncidencia);
    }

    @Override
    public int getItemCount() {
        return listaTipoIncidencia.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Enlazar los controles del cardview mediante binding
        ItemTipoIncidenciaBinding binding;

        public ViewHolder(ItemTipoIncidenciaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void mostrarDatos(TipoIncidencia tipoIncidencia) {
            binding.imgTipoIncidencia.setImageResource(tipoIncidencia.getIcono());
            binding.txtNombreIncidencia.setText(tipoIncidencia.getNombre());
            binding.txtDescripcionIncidencia.setText(tipoIncidencia.getDescripcion());
            binding.cardTipoIncidencia.setOnClickListener(v -> {
                Toast.makeText(
                        binding.getRoot().getContext(),
                        tipoIncidencia.getNombre(),
                        Toast.LENGTH_SHORT
                ).show();
            });
        }
    }
}
