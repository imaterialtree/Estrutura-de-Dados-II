package hash.colisaoTratamento.encadeado;

import java.util.Arrays;

public class InternoHeterogeneo {
    int[] hTable;
    final int m;
    final int p;
    final int s;
    private final int VIRGEM = -1;
    private final int DISPONIVEL = -2;

    public InternoHeterogeneo(int m, int s) {
        this.m = m;
        this.s = s;
        this.p = m-s;
        hTable = new int[m];
        Arrays.fill(hTable, -1);
    }

    int hash(int num) {
        return num % p;
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
        } else {
            for (key=p; key<m; key++) {
                if (hTable[key]<0) {
                    hTable[key] = num;
                    return true;
                }
            }
        }
        return false;
    }

    /*
    * buscar(int num) percorre a tabela bucando num
    * retorna:
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
        for (key=p; key<m; key++) {
            if (hTable[key]==num) {
                return key;
            } else if (hTable[key]==VIRGEM) {
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
        for (key=p; key<m; key++) {
            if (hTable[key]==num) {
                hTable[key] = -2;
                return true;
            } else if (hTable[key]==VIRGEM) {
                return false;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "p:" + Arrays.toString(Arrays.copyOfRange(hTable, 0, p)) +
                " s:" + Arrays.toString(Arrays.copyOfRange(hTable, p, m));
    }
}