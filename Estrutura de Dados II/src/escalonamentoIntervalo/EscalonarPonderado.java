package escalonamentoIntervalo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EscalonarPonderado {
    /* 
    Procura o último intervalo (em uma lista ordenada)
    que não colide com intervalo i. Se encontrar,
    retorno esse intervalo, do contrário retorna -1.
    */ 
    static int ultimoSemConflito(IntervaloPonderado[] vet, int i)
    {
        for (int j = i - 1; j >= 0; j--) {
            // checa se termina antes que o próximo inicia
            if (vet[j].getFim() <= vet[i].getInicio())
                return j;
        }
        return -1;
    }

    static int maiorLucroDP(IntervaloPonderado[] vet, int n){

        // Cria um vetor para armazenar as soluções dos subproblemas
        // dp[i] armazena o valor dos intervalos até vet[i] (inclusive)
        int[] dp = new int[n];
        dp[0] = vet[0].getValor();
        int[] prevIndice = new int[n];
        prevIndice[0] = -1;

        // Preenche as entradas
        for (int i = 1; i < n; i++) {
            // Encontrar o valor incluindo o intervalo atual
            int valorInclusive = vet[i].getValor();
            int ultimo = ultimoSemConflito(vet, i);
            if (ultimo != -1)
                valorInclusive += dp[ultimo];
            prevIndice[i] = ultimo;
            // Armazena o maior entre inclusive e exclusive
            dp[i] = Math.max(valorInclusive, dp[i-1]);
        }
        // Printa intervalos escolhidos
        List<IntervaloPonderado> selectedJobs = new ArrayList<>();
        int index = n - 1;
        while (index >= 0) {
            if (vet[index].getValor() + (prevIndice[index] > 0 ? dp[prevIndice[index]] : 0) == dp[index]) {
                selectedJobs.add(vet[index]);
                index = prevIndice[index];
            } else {
                index--;
            }
        }
        System.out.print("Intervalos escolhidos: ");
        for (int i=selectedJobs.size()-1; i>=0; i--) {
            System.out.print(selectedJobs.get(i).getId()+" ");
        }
        System.out.println();
        // retorna o último elemento

        return dp[n - 1];
    }

    // Driver program
    public static void main(String[] args) {
        IntervaloPonderado[] intervalos = new IntervaloPonderado[8];
        intervalos[0] = new IntervaloPonderado("A", 0, 6, 3);
        intervalos[1] = new IntervaloPonderado("B", 1, 4, 1);
        intervalos[2] = new IntervaloPonderado("C", 3, 5, 2);
        intervalos[3] = new IntervaloPonderado("D", 3, 8, 5);
        intervalos[4] = new IntervaloPonderado("E", 4, 7, 3);
        intervalos[5] = new IntervaloPonderado("F", 5, 9, 6);
        intervalos[6] = new IntervaloPonderado("G", 6, 10, 7);
        intervalos[7] = new IntervaloPonderado("H", 8, 11, 5);

        Arrays.sort(intervalos, Comparator.comparing(IntervaloPonderado::getFim));
        Arrays.asList(intervalos).forEach(System.out::println);
        System.out.println("O maior valor é "
                + maiorLucroDP(intervalos, intervalos.length));
    }
}
