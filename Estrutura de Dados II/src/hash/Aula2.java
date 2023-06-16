package hash;

import java.util.HashMap;

public class  Aula2 {
    public static void main(String[] args) {
        HashMap<String, String> tabela = new HashMap<>();

        tabela.put("355", "Takeshi");
        tabela.put("415", "Gearle");
        tabela.put("777", "Everton");
        tabela.put("888", "Hendrew");
        tabela.put("954", "Sara");
        tabela.put("444", "Naoki");
        tabela.put("514", "Gean");
        tabela.put("1325", "Gean");

        for (String key : tabela.keySet()) {
            System.out.println(myHash(key)+" \t"+key+" \t"+tabela.get(key));
        }
    }
    static int myHash(String key) {
        int[] primos = new int[] {2, 3, 5, 7, 11, 13, 17, 19};
        int hash = 0;
        for (int i=0; i<key.length(); i++){
            int n1 = Integer.parseInt(key.substring(i, i+1));
            hash += n1*primos[i];
        }
        return hash;
    }
}
