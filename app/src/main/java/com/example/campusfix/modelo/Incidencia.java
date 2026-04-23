package com.example.campusfix.modelo;

import androidx.annotation.NonNull;

public class Incidencia {
    private String ambiente;
    private String tipoIncidencia;
    private String descripcion;
    private String prioridad;
    private Boolean inmediatez;

    public Incidencia(String ambiente, String tipoIncidencia, String descripcion, String prioridad, Boolean inmediatez) {
        this.ambiente = ambiente;
        this.tipoIncidencia = tipoIncidencia;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.inmediatez = inmediatez;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(String tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Boolean getInmediatez() {
        return inmediatez;
    }

    public void setInmediatez(Boolean inmediatez) {
        this.inmediatez = inmediatez;
    }
    @NonNull
    @Override
    public String toString(){
        return ambiente + " - " + tipoIncidencia;
    }
}
