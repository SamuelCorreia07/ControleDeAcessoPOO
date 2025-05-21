package com.senai.model.curso;

import com.senai.model.usuario.Professor;

import java.util.ArrayList;
import java.util.List;

public class UC {
    private String nome;
    private List<Professor> professores = new ArrayList<>();
    private int cargaHoraria;
    private int qtdSemestres;

    public UC(String nome, int cargaHoraria, int qtdSemestres) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.qtdSemestres = qtdSemestres;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getQtdSemestres() {
        return qtdSemestres;
    }

    public void setQtdSemestres(int qtdSemestres) {
        this.qtdSemestres = qtdSemestres;
    }
}
