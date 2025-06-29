package com.senai.view.usuario.aluno;

import com.senai.control.usuario.aluno.AlunoController;
import com.senai.model.usuario.aluno.Aluno;
import java.util.List;
import java.util.Scanner;

public class AlunoView {
    private final Scanner scanner = new Scanner(System.in);
    private final AlunoController controller = new AlunoController();

    public static void main(String[] args) {
        AlunoView view = new AlunoView();
        view.menuAlunoView();
    }

    public void menuAlunoView() {
        String opcao;
        String menuPrincipal = """
                
                _____________________________________________________________
                |   Escolha uma opção:                                      |
                |                                                           |
                |       1 - Cadastrar alun@                                 |
                |       2 - Atualizar alun@                                 |
                |       3 - Remover alun@                                   |
                |       4 - Listar alun@s                                   |
                |       0 - Voltar                                          |
                |___________________________________________________________|
                """;
        do {
            System.out.print(menuPrincipal);
            opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1" -> cadastrarAluno();
                case "2" -> atualizarAluno();
                case "3" -> removerAluno();
                case "4" -> listarAlunos();
                case "0" -> System.out.println("\nVoltando ao menu principal...");
                default -> System.out.println("\nOpção inválida!");
            }
        } while (!opcao.equals("0"));
    }

    private void cadastrarAluno() {
        String nome = scannerPromptString("\tNome d@ alun@: ");
        int idade = scannerPromptInt("\tIdade d@ alun@: ", "\nPor favor, insira uma idade válida.");
        String login = scannerPromptString("\tLogin do alun@: ");
        String senha = scannerPromptString("\tSenha do alun@: ");
        String rfid = scannerPromptString("\tRFID do alun@: ");
        String resultado = controller.cadastrarAluno(nome, idade, login, senha, rfid);
        System.out.println(resultado);
    }

    private void atualizarAluno() {
        int id = scannerPromptInt("\tID d@ alun@: ", "\nPor favor, insira um ID válido.");
        String nome = scannerPromptString("\tNovo nome d@ alun@: ");
        int idade = scannerPromptInt("\tNova idade d@ alun@: ", "\nPor favor, insira uma idade válida.");
        String login = scannerPromptString("\tNovo login d@ alun@: ");
        String senha = scannerPromptString("\tNova senha d@ alun@: ");
        String rfid = scannerPromptString("\tNovo RFID d@ alun@: ");
        String resultado = controller.atualizarAluno(id, nome, idade, login, senha, rfid);
        System.out.println(resultado);
    }

    private void removerAluno() {
        int id = scannerPromptInt("\tID d@ alun@: ", "\nPor favor, insira um ID válido.");
        System.out.print("\nTem certeza que deseja remover o cadastro d@ alun@ com ID '" + id + "'? (S/N): ");
        String confirmacao = scanner.nextLine().trim().toUpperCase();
        if (confirmacao.equals("S")) {
            String resultado = controller.removerAluno(id);
            System.out.println(resultado);
        } else {
            System.out.println("\nRemoção cancelada!");
        }
    }

    private void listarAlunos() {
        List<Aluno> alunos = controller.listarAlunos();
        if (alunos.isEmpty()) {
            System.out.println("\nNenhum alun@ encontrad@!");
        } else {
            for (Aluno a : alunos) {
                System.out.println(a);
            }
        }
    }

    private String scannerPromptString(String msg) {
        System.out.print(msg);
        return scanner.nextLine().trim();
    }

    private int scannerPromptInt(String msg, String erroMsg) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(msg);
                numero = Integer.parseInt(scanner.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println(erroMsg);
            }
        }
        return numero;
    }
}