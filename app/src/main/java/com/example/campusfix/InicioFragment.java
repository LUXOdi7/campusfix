package com.example.campusfix;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.campusfix.databinding.FragmentInicioBinding;

public class InicioFragment extends Fragment {
    FragmentInicioBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInicioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//
//        binding.btnVerIncidenciasRegistradas.setOnClickListener(v -> {
//            NavHostFragment.findNavController(InicioFragment.this).navigate(R.id.nav_especialidades);
//        });
//        binding.btnVerIncidenciasProceso.setOnClickListener(v -> {
//            NavHostFragment.findNavController(InicioFragment.this).navigate(R.id.nav_especialidades);
//        });
//        binding.btnVerIncidenciasResueltas.setOnClickListener(v -> {
//            NavHostFragment.findNavController(InicioFragment.this).navigate(R.id.nav_medicos);
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}