import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class GerenciadorAlunos {
    private Stack<Aluno> pilhaAlunos;
    private int proximoNumero;

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
        Aluno aluno = pilhaAlunos.peek();
        if (aluno.temNotas()) {
            System.out.println("Este aluno possui notas, logo, não poderá ser excluído.");
            return false;
        }
        pilhaAlunos.pop();
        System.out.println("Aluno excluído.");
        return true;
    }

    public List<Aluno> listarAlunosSemNotas() {
        List<Aluno> alunosSemNotas = new ArrayList<>();
        for (Aluno aluno : pilhaAlunos) {
            if (!aluno.temNotas()) {
                alunosSemNotas.add(aluno);
            }
        }
        return alunosSemNotas;
    }

    public boolean temAlunos() {
        return !pilhaAlunos.isEmpty();
    }

    public Aluno obterUltimoAluno() {
        if (pilhaAlunos.isEmpty()) {
            return null;
        }
        return pilhaAlunos.peek();
    }
}
