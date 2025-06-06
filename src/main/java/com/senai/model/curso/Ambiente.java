package com.senai.model.curso;

public class Ambiente {
        private int id;
        private String nome;
        private String tipo;

        public Ambiente(int id, String nome, String tipo) {
            this.id = id;
            this.nome = nome;
            this.tipo = tipo;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getTipo() {
            return tipo;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Nome: " + nome + " | Tipo: " + tipo;
        }
    }

