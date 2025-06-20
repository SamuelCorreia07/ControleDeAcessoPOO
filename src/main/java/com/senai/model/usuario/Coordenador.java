package com.senai.model.usuario;

public class Coordenador extends Usuario {
    private String departamento;

    public Coordenador(int id, String nome, String login, String senha, String departamento) {
        super(id, nome, login, senha);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String getTipo() {
        return "Coordenador";
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | Login: %s | Departamento: %s | Tipo: %s",
                getId(), getNome(), getLogin(), departamento, getTipo());
    }
}
