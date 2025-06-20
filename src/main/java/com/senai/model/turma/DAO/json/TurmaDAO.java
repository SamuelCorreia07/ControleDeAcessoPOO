package com.senai.model.turma.DAO.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.model.curso.Curso;

import com.senai.model.turma.Subturma;
import com.senai.model.turma.Turma;
import com.senai.model.usuario.aluno.Aluno;
import com.senai.util.LocalTimeAdapter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurmaDAO {
    private List<Turma> turmas;
    private final String caminho = "json_data/turmas.json";
    private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalTime.class, new LocalTimeAdapter()).setPrettyPrinting().create();

    private List<Turma> carregar(){
        try(FileReader reader = new FileReader(caminho)){
            Type listType = new TypeToken<ArrayList<Curso>>(){}.getType();
            return gson.fromJson(reader, listType);
        }catch (IOException e){
            return new ArrayList<>();
        }
    }

    public TurmaDAO() {
        turmas = carregar();
    }

    private void salvarJson(){
        try(FileWriter writer = new FileWriter(caminho)){
            gson.toJson(turmas, writer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void inserir(Turma turma){
        int novoId = turmas.stream().mapToInt(Turma::getIdTurma).max().orElse(0) + 1;
        turma.setIdTurma(novoId);

        turma.setSubturmas(new ArrayList<>());

        Subturma subturma = new Subturma();
        subturma.setAlunos(new ArrayList<>());

        turma.getSubturmas().add(subturma);

        turmas.add(turma);
        salvarJson();
    }

    public List<Turma> listar(){
        return turmas;
    }

    public void atualizar(Turma turma){
        for (int i = 0; i < turmas.size(); i++) {
            if (turmas.get(i).getIdTurma() == turma.getIdTurma()){
                turmas.set(i, turma);
                break;
            }
            salvarJson();
        }
    }

    public void deletar(int id){
        turmas.removeIf(turma -> turma.getIdTurma() == id);
        salvarJson();
    }

    public Optional<Turma> buscarPorId(int id) {
        return turmas.stream().filter(t -> t.getIdTurma() == id).findFirst();
    }

    public Optional<Turma> buscarPorAluno(Aluno aluno) {
        return turmas.stream()
                .filter(t ->
                        t.getSubturmas().stream()
                                .anyMatch(subTurma ->
                                        subTurma.getAlunos().stream()
                                                .anyMatch(a -> a.equals(aluno))
                                )
                ).findFirst();
    }

    public void adicionarAlunosNaSubturma(Subturma subTurma, List<Aluno> alunos) {
        turmas.stream()
                .filter(turma ->
                        turma.getSubturmas().contains(subTurma)
                ).findFirst().flatMap(
                        turma -> turma.getSubturmas().stream()
                                .filter(
                                        s -> s.equals(subTurma)
                                ).findFirst()
                ).ifPresent(
                        s -> s.getAlunos().addAll(alunos)
                );
    }
}
