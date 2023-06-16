package hash.colisaoTratamento.encadeado;

import java.util.Arrays;

public class InternoHomogeneo {
    int[] hTable;
    final int m;
    private final int VIRGEM = -1;
    private final int DISPONIVEL = -2;

    public InternoHomogeneo(int m) {
        this.m = m;
        hTable = new int[m];
        Arrays.fill(hTable, -1);
    }

    int hash(int num) {
        return num % m;
    }

    /*
     * inserir(int num) busca um espaço vazio
     * se encontrar, insere num e retorna true
     * senão, retorna false
     */
    public boolean inserir(int num) {
        if(num<0) {
            return false;
        }
        int key = hash(num);
        if (hTable[key]<0) {
            hTable[key] = num;
            return true;
        }
        // percorre em loop (volta ao inicio quando encontra o fim do vetor)
        for (int k=key+1; k!=key; k=++k % m) {
            if (hTable[k]<0) {
                hTable[k] = num;
                return true;
            }
        }
        return false;
    }

    /*
     * buscar(int num) percorre a tabela bucando num e retorna:
     * -1, se num não for encontrado
     * indice de num, se num estiver na tabela
     */
    public int buscar(int num) {
        int key = hash(num);
        if (hTable[key]==VIRGEM) {
            return -1;
        }
        if (hTable[key]==num) {
            return key;
        }
        // percorre em loop (volta ao inicio quando encontra o fim do vetor)
        for (int k=key+1; k!=key; k=++k % m) {
            if (hTable[k]==num) {
                return k;
            } else if (hTable[k]==VIRGEM) {
                return -1;
            }
        }
        return -1;
    }

    /*
     * remover(int num) busca num na tabela hash
     * se encontrar, sobrescreve num por DISPONIVEL e retorna true
     * se não encontrar, retorna false
     */
    public boolean remover(int num) {
        int key = hash(num);
        if (hTable[key]==VIRGEM) {
            return false;
        }
        if (hTable[key]==num) {
            hTable[key] = DISPONIVEL;
            return true;
        }
        // percorre em loop (volta ao inicio quando encontra o fim do vetor)
        for (int k=key+1; k!=key; k=++k % m) {
            if (hTable[k]==num) {
                hTable[k] = -2;
                return true;
            } else if (hTable[k]==VIRGEM) {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(hTable);
    }
}
