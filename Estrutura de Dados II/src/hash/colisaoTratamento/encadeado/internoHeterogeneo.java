package hash.colisaoTratamento.encadeado;

import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class internoHeterogeneo {
    TableValue[] hTable;
    int m = 10;
    int p = 6;
    int s = m-p;

    int hash(int num) {
        return num % p;
    }

    public boolean adicionar(int num) {
        if(num<0) {
            return false;
        }
        int key = hash(num);
        if (hTable[key]==null) {
            hTable[key] = new TableValue(num);
        } else {
            for (int k=p; k<m; k++) {
                if (hTable[k]==null) {
                    hTable[key].nextKey = k;
                    hTable[k] = new TableValue(num);
                }
            }
        }
        return true;
    }
    public boolean buscar(int num) {
        int key = hash(num);
        if (hTable[key]==null) {
            return false;
        }
        if (hTable[key].value==num) {
            return true;
        }
        while(hTable[key].nextKey!=null) {
            key = hTable[key].nextKey;
            if (hTable[key].value==num) {
                return true;
            }
        }
        return false;
    }

    public boolean remover(int num) {
        int key = hash(num);
        if (hTable[key]==null) {
            return false;
        }
        if (hTable[key].value==num) {
            hTable[key].value = -1;
            return true;
        }
        while(hTable[key].nextKey!=null) {
            key = hTable[key].nextKey;
            if (hTable[key].value==num) {
                return true;
            }
        }
        return false;
    }
}

class TableValue {
    int value;
    Integer nextKey; // chave do próximo sinonimo

    TableValue(int value) {
        this.value = value;
    }

}
