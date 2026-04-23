package com.example.campusfix;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.campusfix.adaptador.AmbienteAdaptador;
import com.example.campusfix.databinding.FragmentAmbientesBinding;
import com.example.campusfix.datos.DatosIncidencias;
import com.example.campusfix.modelo.Ambiente;

import java.util.ArrayList;


public class AmbientesFragment extends Fragment {

    FragmentAmbientesBinding binding;
    ArrayList<Ambiente> listaAmbientes;
    AmbienteAdaptador ambienteAdaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAmbientesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Cargar las especialidades almacenadas en el array
        DatosIncidencias.cargarAmbientes();
        listaAmbientes = DatosIncidencias.listaAmbientes;
        ambienteAdaptador = new AmbienteAdaptador(listaAmbientes);

        // Configurar el recyclerView
        binding.rvAmbientes.setLayoutManager(new LinearLayoutManager(requireContext()));
        // Asignar el adaptador al recyclerView
        binding.rvAmbientes.setAdapter(ambienteAdaptador);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}