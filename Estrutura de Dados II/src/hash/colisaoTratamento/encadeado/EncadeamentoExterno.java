package hash.colisaoTratamento.encadeado;

import hash.Entrada;

import java.util.Arrays;
import java.util.LinkedList;

public class EncadeamentoExterno {
    LinkedList<Entrada>[] hTable; // usando vetor de sets como hashTable
    private final int TAMANHO;

    public EncadeamentoExterno(int TAMANHO) {
        this.TAMANHO = TAMANHO;
        hTable = new LinkedList[TAMANHO];
        for (int i = 0; i< TAMANHO; i++) {
            hTable[i] = new LinkedList<>();
        }
    }
    int hash(int value) {
        return value % TAMANHO;
    }

    // return false se a chave não existia
    // return true se a chave já existia e atualiza o valor
    public boolean inserir(int key, int value) {
        if (value<0) {
            return false;
        }
        int indice = hash(value);
        LinkedList<Entrada> lista = hTable[indice];
        for (Entrada e : lista) {
            if (e.getKey()==(key)) {
                e.setValue(value);
                return true;
            }
        }
        lista.add(new Entrada(key, value));
        return true;
    }

    public int buscar(int key) {
        int indice = hash(key);
        LinkedList<Entrada> lista = hTable[indice];

        for (Entrada e : lista) {
            if (e.getKey()==(key)) {
                return e.getValue();
            }
        }

        return -1;
    }

    // return false se não encontrar
    // return true se remover com sucesso
    public boolean remover(int key) {
        int indice = hash(key);
        LinkedList<Entrada> lista = hTable[indice];

        for (Entrada e : lista) {
            if (e.getKey()==(key)) {
                return lista.remove(e);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder view = new StringBuilder();
        for (int i = 0; i < hTable.length; i++) {
            view.append(String.format("[%d]-> %s\n", i, hTable[i].toString()));
        }
        return view.toString();
    }
}
