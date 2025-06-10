package com.senai.model.turma.horario.DAO;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.senai.model.turma.horario.Horario;
import com.senai.util.LocalTimeAdapter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.*;

public class HorarioDAO {
    private final String caminho = "horarios.json";
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
            .create();
    private final List<Horario> horarios;

    public HorarioDAO(){
        horarios = carregar();
    }

    private List<Horario> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<Horario>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.out.println("Erro ao carregar os horários: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private void salvar(List<Horario> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os horários: " + e.getMessage());
        }
    }

    public void inserir(Horario horario) {
        int novoId = horarios.stream().mapToInt(Horario::getId).max().orElse(0) + 1;
        horario.setId(novoId);
        horarios.add(horario);
        salvar(horarios);
    }

    public void atualizar(Horario horario) {
        for (int i = 0; i < horarios.size(); i++) {
            if (horarios.get(i).getId() == horario.getId()) {
                horarios.set(i, horario);
                break;
            }
        }
        salvar(horarios);
    }

    public void remover(int id) {
        horarios.removeIf(h -> h.getId() == id);
        salvar(horarios);
    }

    public List<Horario> listarTodos() {
        return horarios;
    }

    public Optional<Horario> buscarPorId(int id) {
        return horarios.stream()
                .filter(h -> h.getId() == id)
                .findFirst();
    }
}