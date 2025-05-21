package com.senai.model.turma;

import java.util.List;

public class Turma {
    private String nome;
    private String curso;
    private List<Subturma> subturmas;
    private String dataInicio;
    private int qtdSemestre;
    private String horarioEntrada;

    public Turma(String nome, String curso, String dataInicio, int qtdSemestre, String horarioEntrada, List<Subturma> subturmas) {
        this.nome = nome;
        this.curso = curso;
        this.dataInicio = dataInicio;
        this.qtdSemestre = qtdSemestre;
        this.horarioEntrada = horarioEntrada;
        this.subturmas = subturmas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Subturma> getSubturmas() {
        return subturmas;
    }

    public void setSubturmas(List<Subturma> subturmas) {
        this.subturmas = subturmas;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getQtdSemestre() {
        return qtdSemestre;
    }

    public void setQtdSemestre(int qtdSemestre) {
        this.qtdSemestre = qtdSemestre;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }
}
