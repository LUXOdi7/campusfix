package com.example.campusfix;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.campusfix.adaptador.TipoIncidenciaAdaptador;
import com.example.campusfix.databinding.FragmentRegistrarIncidenciaBinding;
import com.example.campusfix.datos.DatosIncidencias;
import com.example.campusfix.modelo.Ambiente;
import com.example.campusfix.modelo.Incidencia;
import com.example.campusfix.modelo.TipoIncidencia;

import java.util.ArrayList;


public class RegistrarIncidenciaFragment extends Fragment {
    FragmentRegistrarIncidenciaBinding binding;
//    ArrayList<Incidencia> listaIncidencias;
//    ArrayList<Ambiente> listaAmbientes;
//    ArrayList<TipoIncidencia> listaTipoIncidencia;

    public RegistrarIncidenciaFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        binding = FragmentRegistrarIncidenciaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DatosIncidencias.cargarAmbientes();
        DatosIncidencias.cargarTiposIncidencias();
        cargarAmbientes();
        cargarTipoIncidencias();
        binding.btnRegistrarIncidencia.setOnClickListener(v -> {
            registrarIncidencia();
        });
    }

    public void registrarIncidencia() {
        String ambiente = binding.actAmbiente.getText().toString();
        String tipoIncidencia = binding.actTipoIncidencia.getText().toString();
        String descripcion = binding.txtDescripcion.getText().toString();
        String strPrioridad = "";
        Boolean inmediatez = binding.cbInmediatez.isChecked();
        int prioridadSel = binding.rgPrioridad.getCheckedRadioButtonId();
        if (ambiente.isEmpty()) {
            tMsg("Debe seleccionar un ambiente");
        }
        if (tipoIncidencia.isEmpty()) {
            tMsg("Debe seleccionar un tipo de incidencia");
        }
        if (descripcion.isEmpty()) {
            tMsg("Debe escribir una descripción");
        }
        if (prioridadSel == -1) {
            tMsg("Debe seleccionar un ambiente");
        } else {
            RadioButton rbPrioridadSel = binding.rgPrioridad.findViewById(prioridadSel);
            strPrioridad = rbPrioridadSel.getText().toString();
        }
        DatosIncidencias.agregarIncidencia(
                new Incidencia(ambiente, tipoIncidencia, descripcion, strPrioridad, inmediatez)
        );
        tMsg("Incidencia Registrada");
        limpiarCampos();
    }
    private void limpiarCampos(){
        binding.actAmbiente.setText("");
        binding.actTipoIncidencia.setText("");
        binding.txtDescripcion.setText("");
        binding.rgPrioridad.clearCheck();
        binding.cbInmediatez.setChecked(false);

        binding.actAmbiente.clearFocus();
        binding.actTipoIncidencia.clearFocus();
        binding.txtDescripcion.clearFocus();
    }

    private void tMsg(String mensaje) {
        Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
    }

    private void cargarAmbientes() {
        ArrayAdapter<Ambiente> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                DatosIncidencias.listaAmbientes
        );
        binding.actAmbiente.setAdapter(adapter);
    }

    private void cargarTipoIncidencias() {
        ArrayAdapter<TipoIncidencia> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                DatosIncidencias.listaTipoIncidencias
        );
        binding.actTipoIncidencia.setAdapter(adapter);
    }


}