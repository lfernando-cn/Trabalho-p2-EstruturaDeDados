import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Menu {
    private GerenciadorAlunos gerenciadorAlunos;
    private Scanner scanner;

    public Menu() {
        gerenciadorAlunos = new GerenciadorAlunos();
        scanner = new Scanner(System.in);
    }

    public void exibir() {
        int opcao;
        do {
            System.out.println("MENU");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar nota");
            System.out.println("3 - Calcular média de um aluno");
            System.out.println("4 - Listar os nomes dos alunos sem notas");
            System.out.println("5 - Excluir aluno");
            System.out.println("6 - Excluir nota");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarNota();
                    break;
                case 3:
                    calcularMediaAluno();
                    break;
                case 4:
                    listarAlunosSemNotas();
                    break;
                case 5:
                    excluirAluno();
                    break;
                case 6:
                    excluirNota();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 7);
    }

    private void cadastrarAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        gerenciadorAlunos.cadastrarAluno(nome);
    }

    private void cadastrarNota() {
        System.out.print("Digite o número do aluno: ");
        int numeroAluno = scanner.nextInt();
        System.out.print("Digite a nota: ");
        double nota = scanner.nextDouble();
        Aluno aluno = gerenciadorAlunos.buscarAluno(numeroAluno);
        if (aluno != null) {
            aluno.adicionarNota(nota);
            System.out.println("Nota cadastrada.");
        } else {
            System.out.println("Aluno não cadastrado.");
        }
    }

    private void calcularMediaAluno() {
        System.out.print("Digite o número do aluno: ");
        int numeroAluno = scanner.nextInt();
        Aluno aluno = gerenciadorAlunos.buscarAluno(numeroAluno);
        if (aluno == null) {
            System.out.println("Aluno não cadastrado.");
            return;
        }

        List<Double> notas = aluno.getNotas();
        if (notas.isEmpty()) {
            System.out.println("Aluno sem notas.");
            return;
        }

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.size();
        System.out.println("Média do aluno " + aluno.getNome() + " = " + media);
    }

    private void listarAlunosSemNotas() {
        List<Aluno> alunosSemNotas = gerenciadorAlunos.listarAlunosSemNotas();
        if (alunosSemNotas.isEmpty()) {
            System.out.println("Todos os alunos possuem notas.");
        } else {
            System.out.println("Alunos sem notas:");
            for (Aluno aluno : alunosSemNotas) {
                System.out.println(aluno.getNome());
            }
        }
    }

    private void excluirAluno() {
        if (!gerenciadorAlunos.temAlunos()) {
            System.out.println("Pilha vazia.");
            return;
        }
        gerenciadorAlunos.excluirAluno();
    }

    private void excluirNota() {
        System.out.print("Digite o número do aluno: ");
        int numeroAluno = scanner.nextInt();
        Aluno aluno = gerenciadorAlunos.buscarAluno(numeroAluno);
        if (aluno != null && aluno.excluirNota()) {
            System.out.println("Nota excluída.");
        } else {
            System.out.println("Aluno não cadastrado ou sem notas para excluir.");
        }
    }
}

