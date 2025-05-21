package com.senai.model.curso;

import java.util.List;

public class Curso {
    private String titulo;
    private List<UC> ucs;
    private int cargaHoraria;
    private String tipo;
    private int tolerancia;

    public Curso(String titulo, List<UC> ucs, int cargaHoraria, String tipo, int tolerancia) {
        this.titulo = titulo;
        this.ucs = ucs;
        this.cargaHoraria = cargaHoraria;
        this.tipo = tipo;
        this.tolerancia = tolerancia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<UC> getUcs() {
        return ucs;
    }

    public void setUcs(List<UC> ucs) {
        this.ucs = ucs;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(int tolerancia) {
        this.tolerancia = tolerancia;
    }
}
