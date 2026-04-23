package com.example.campusfix.datos;

import com.example.campusfix.modelo.Ambiente;
import com.example.campusfix.modelo.Incidencia;
import com.example.campusfix.modelo.TipoIncidencia;

import java.util.ArrayList;

public class DatosIncidencias {

    public static ArrayList<Ambiente> listaAmbientes = new ArrayList<>();
    public static ArrayList<TipoIncidencia> listaTipoIncidencias = new ArrayList<>();
    public static ArrayList<Incidencia> listaIncidencia = new ArrayList<>();

    public static void cargarAmbientes(){
        if (listaAmbientes.isEmpty()){
            listaAmbientes.add(new Ambiente("Laboratorio de cómputo", "COD001", "Laboratorio"));
            listaAmbientes.add(new Ambiente("Aula 101", "COD002", "Aula"));
            listaAmbientes.add(new Ambiente("Aula 202", "COD003", "Aula"));
            listaAmbientes.add(new Ambiente("Biblioteca", "COD004", "Estudio"));
            listaAmbientes.add(new Ambiente("Sala de profesores", "COD005", "Oficina"));
            listaAmbientes.add(new Ambiente("Auditorio principal", "COD006", "Auditorio"));
            listaAmbientes.add(new Ambiente("Taller de electrónica", "COD007", "Taller"));
            listaAmbientes.add(new Ambiente("Laboratorio de química", "COD008", "Laboratorio"));
            listaAmbientes.add(new Ambiente("Área administrativa", "COD009", "Oficina"));
            listaAmbientes.add(new Ambiente("Cafetería", "COD010", "Servicios"));
            listaAmbientes.add(new Ambiente("Sala de reuniones", "COD011", "Oficina"));
            listaAmbientes.add(new Ambiente("Cancha deportiva", "COD012", "Recreación"));
        }
    }
    public static void cargarTiposIncidencias() {
        if (listaTipoIncidencias.isEmpty()) {
            listaTipoIncidencias.add(new TipoIncidencia("Falla eléctrica", "Interrupción o mal funcionamiento del suministro eléctrico", android.R.drawable.ic_dialog_alert));
            listaTipoIncidencias.add(new TipoIncidencia("Equipo averiado", "Equipo o dispositivo que no funciona correctamente", android.R.drawable.ic_menu_manage));
            listaTipoIncidencias.add(new TipoIncidencia("Mobiliario dañado", "Muebles en mal estado o rotos", android.R.drawable.ic_menu_crop));
            listaTipoIncidencias.add(new TipoIncidencia("Problema de limpieza", "Suciedad o falta de mantenimiento en el área", android.R.drawable.ic_menu_delete));
            listaTipoIncidencias.add(new TipoIncidencia("Conectividad de red", "Problemas con la conexión a internet o red interna", android.R.drawable.ic_menu_share));
            listaTipoIncidencias.add(new TipoIncidencia("Aire acondicionado no funciona", "El sistema de aire acondicionado no enfría o no enciende", android.R.drawable.ic_menu_compass));
            listaTipoIncidencias.add(new TipoIncidencia("Iluminación deficiente", "Falta de iluminación adecuada en el área", android.R.drawable.ic_menu_gallery));
            listaTipoIncidencias.add(new TipoIncidencia("Ruido excesivo", "Nivel de ruido que afecta el ambiente de trabajo", android.R.drawable.ic_lock_silent_mode_off));
        }
    }
    public static void agregarIncidencia(Incidencia incidencia) {
        listaIncidencia.add(incidencia);
    }

}
