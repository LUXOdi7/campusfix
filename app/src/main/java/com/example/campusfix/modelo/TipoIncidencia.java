package com.example.campusfix.modelo;

import androidx.annotation.NonNull;

public class TipoIncidencia {
    private String nombre;
    private String descripcion;
    private int icono;

    public TipoIncidencia(String nombre, String descripcion, int icono) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    @NonNull
    @Override
    public String toString(){
        return nombre;
    }
}
