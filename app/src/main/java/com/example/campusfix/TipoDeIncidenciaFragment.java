package com.example.campusfix;

import static com.example.campusfix.datos.DatosIncidencias.listaTipoIncidencias;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.campusfix.adaptador.TipoIncidenciaAdaptador;
import com.example.campusfix.databinding.FragmentTiposDeIncidenciaBinding;
import com.example.campusfix.datos.DatosIncidencias;
import com.example.campusfix.modelo.TipoIncidencia;

import java.util.ArrayList;


public class TipoDeIncidenciaFragment extends Fragment {

    FragmentTiposDeIncidenciaBinding binding;
    ArrayList<TipoIncidencia> listaTipoIncidencia;
    TipoIncidenciaAdaptador tipoIncidenciaAdaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTiposDeIncidenciaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Cargar las especialidades almacenadas en el array
        DatosIncidencias.cargarTiposIncidencias();
        listaTipoIncidencia = listaTipoIncidencias;
        tipoIncidenciaAdaptador = new TipoIncidenciaAdaptador(listaTipoIncidencias);

        // Configurar el recyclerView
        binding.rvTipoIncidencia.setLayoutManager(new LinearLayoutManager(requireContext()));
        // Asignar el adaptador al recyclerView
        binding.rvTipoIncidencia.setAdapter(tipoIncidenciaAdaptador);


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}