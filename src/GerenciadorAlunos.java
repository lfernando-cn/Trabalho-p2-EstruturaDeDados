import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class GerenciadorAlunos {
    private Stack<Aluno> pilhaAlunos;
    public int proximoNumero;

    public GerenciadorAlunos() {
        pilhaAlunos = new Stack<>();
        proximoNumero = 1;
    }

    public void cadastrarAluno(String nome) {
        Aluno aluno = new Aluno(proximoNumero++, nome);
        pilhaAlunos.push(aluno);
        System.out.println("Aluno cadastrado.");
    }

    public Aluno buscarAluno(int numero) {
        for (Aluno aluno : pilhaAlunos) {
            if (aluno.getNumero() == numero) {
                return aluno;
            }
        }
        return null;
    }

    public boolean excluirAluno() {
        if (pilhaAlunos.isEmpty()) {
            System.out.println("Pilha vazia.");
            return false;
        }
        pilhaAlunos.pop();
        System.out.println("Aluno excluído.");
        return true;
    }

    public List<Aluno> listarAlunosSemNotas(Set<Integer> alunosComNotas) {
        List<Aluno> alunosSemNotas = new ArrayList<>();
        for (Aluno aluno : pilhaAlunos) {
            if (!alunosComNotas.contains(aluno.getNumero())) {
                alunosSemNotas.add(aluno);
            }
        }
        return alunosSemNotas;
    }
    public boolean temAlunos() {
        return !pilhaAlunos.isEmpty();
    }
}