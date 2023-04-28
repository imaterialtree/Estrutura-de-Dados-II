package hash.colisaoTratamento.encadeado;

import java.util.HashSet;
import java.util.Set;

public class EncadeamentoExterno {
    Set<Integer>[] hTable; // usando vetor de sets como hashTable
    int m;

    public EncadeamentoExterno(int m) {
        this.m = m;
        hTable = new Set[m];
        for (int i=0; i<m; i++) {
            hTable[i] = null;
        }
    }
    int hash(int value) {
        return value % m;
    }
    public boolean adicionar(int key) {
        if (hTable[hash(key)]==null) {
            hTable[hash(key)] = new HashSet<>();
        }
        return hTable[hash(key)].add(key);
    }

    public boolean busca(int key) {
        if (hTable[hash(key)]!=null) {
            return hTable[hash(key)].contains(key);
        }
        return false;
    }
    public boolean remover(int key) {
        if (hTable[hash(key)]!=null) {
            return hTable[hash(key)].remove(key);
        }
        return false;
    }
}
