package com.example.campusfix.adaptador;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusfix.databinding.ItemAmbienteBinding;
import com.example.campusfix.modelo.Ambiente;

import java.util.ArrayList;

public class AmbienteAdaptador extends RecyclerView.Adapter<AmbienteAdaptador.ViewHolder>{
    private ArrayList<Ambiente> listaAmbientes;

    public AmbienteAdaptador(ArrayList<Ambiente> listaAmbientes) {
        this.listaAmbientes = listaAmbientes;
    }

    public void actualizarListaAmbientes(ArrayList<Ambiente> listaAmbientes){
        this.listaAmbientes = listaAmbientes;
        // Con la finalidad de que el Recycler view se refresque, aplicamos notifyDataSetChanged()
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Permite vincular el adaptador con el archivo que contiene la plantilla MaterialCardView
        ItemAmbienteBinding binding = ItemAmbienteBinding.inflate
                (
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false

                );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Permite gestionar la inversion de los datos de la plantilla
        Ambiente ambiente = listaAmbientes.get(position);
        holder.mostrarDatos(ambiente);
    }

    @Override
    public int getItemCount() {
        return listaAmbientes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Permite vincular la clase ViewHolder del adaptador con los controles de la plantilla MaterialCardView
        ItemAmbienteBinding binding;

        public ViewHolder(ItemAmbienteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void mostrarDatos(Ambiente ambiente){
            String tipoAmbiente = ambiente.getTipo();
            binding.txtCodigoAmbiente.setText(ambiente.getCodigo());
            binding.txtAmbienteNombre.setText(ambiente.getNombre());
            binding.txtTipoAmbiente.setText(ambiente.getTipo());
            switch (tipoAmbiente) {
                case "Laboratorio":
                    binding.imgAmbienteTipo.setImageResource(android.R.drawable.ic_menu_info_details);
                    break;
                case "Aula":
                    binding.imgAmbienteTipo.setImageResource(android.R.drawable.ic_delete);
                    break;
                case "Taller":
                    binding.imgAmbienteTipo.setImageResource(android.R.drawable.ic_lock_idle_low_battery);
                    break;
                case "Oficina":
                    binding.imgAmbienteTipo.setImageResource(android.R.drawable.ic_notification_overlay);
                default:
                    binding.imgAmbienteTipo.setImageResource(android.R.drawable.ic_menu_gallery);
                    break;
            }
        }
    }
}
