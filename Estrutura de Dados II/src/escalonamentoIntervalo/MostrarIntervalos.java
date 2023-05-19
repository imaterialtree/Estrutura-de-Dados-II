package escalonamentoIntervalo;

import java.util.Arrays;
import java.util.List;

public class MostrarIntervalos {
    static void printIntervalos(List<Intervalo> vet) {
        for (Intervalo i : vet) {
            char[] nulo = new char[i.getInicio()];
            char[] ativo = new char[i.getFim()-i.getInicio()];
            Arrays.fill(nulo, ' ');
            Arrays.fill(ativo, '#');
            String grafico = new String(nulo) + new String(ativo);
            System.out.println(i.getId()+" "+grafico);
        }
    }
}
