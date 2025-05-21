package com.senai.model.turma;

import com.senai.model.usuario.aluno.Aluno;

import java.util.ArrayList;
import java.util.List;

public class Subturma {
    private String nome;
    private List<Aluno> alunos = new ArrayList<>();
    private String horario;

    public Subturma(String nome, String horario) {
        this.nome = nome;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
