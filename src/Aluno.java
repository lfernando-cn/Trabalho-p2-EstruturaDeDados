import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Aluno {
    private int numero;
    private String nome;
    private Queue<Double> notas;

    public Aluno(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        this.notas = new LinkedList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarNota(double valor) {
        notas.add(valor);
    }

    public boolean excluirNota() {
        if (notas.isEmpty()) {
            return false;
        }
        notas.poll();
        return true;
    }

    public List<Double> getNotas() {
        return new ArrayList<>(notas);
    }

    public boolean temNotas() {
        return !notas.isEmpty();
    }
}
