import java.util.*;

class GerenciadorNotas {
    private Queue<Nota> filaNotas;

    public GerenciadorNotas() {
        filaNotas = new LinkedList<>();
    }

    public void cadastrarNota(int numeroAluno, double valor) {
        Nota nota = new Nota(numeroAluno, valor);
        filaNotas.add(nota);
        System.out.println("Nota cadastrada.");
    }

    public List<Nota> buscarNotasDoAluno(int numeroAluno) {
        List<Nota> notasDoAluno = new ArrayList<>();
        for (Nota nota : filaNotas) {
            if (nota.getNumeroAluno() == numeroAluno) {
                notasDoAluno.add(nota);
            }
        }
        return notasDoAluno;
    }

    public boolean excluirNota() {
        if (filaNotas.isEmpty()) {
            System.out.println("Fila vazia.");
            return false;
        }
        filaNotas.poll();
        System.out.println("Nota excluída.");
        return true;
    }

    public Set<Integer> alunosComNotas() {
        Set<Integer> alunosComNotas = new HashSet<>();
        for (Nota nota : filaNotas) {
            alunosComNotas.add(nota.getNumeroAluno());
        }
        return alunosComNotas;
    }
}