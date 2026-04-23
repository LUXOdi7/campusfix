package com.example.campusfix.modelo;

import androidx.annotation.NonNull;

public class Ambiente {
    private String nombre;
    private String codigo;

    private String tipo;

    public Ambiente(String nombre, String codigo, String tipo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @NonNull
    @Override
    public String toString(){return nombre;}
}
