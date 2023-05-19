package escalonamentoIntervalo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EscalonarSemPeso {
    public static void main(String[] args) {
        // criar intervalos
        List<Intervalo> intervalos = new ArrayList<>();
        intervalos.add(new Intervalo("A", 0, 6));
        intervalos.add(new Intervalo("B", 1, 4));
        intervalos.add(new Intervalo("C", 3, 5));
        intervalos.add(new Intervalo("D", 3, 8));
        intervalos.add(new Intervalo("E", 4, 7));
        intervalos.add(new Intervalo("F", 5, 9));
        intervalos.add(new Intervalo("G", 6, 10));
        intervalos.add(new Intervalo("H", 8, 11));

        intervalos.forEach(System.out::println);
        System.out.println();

        // organizar lista pela deadline mais curta (SDF)
        intervalos.sort(Comparator.comparing(Intervalo::getFim));
        intervalos.forEach(System.out::println);
        System.out.println();

        // verificar disjunção (não simultaneidade)
        for (int i=0; i< intervalos.size()-1; i++) {
            Intervalo iAtual = intervalos.get(i);
            Intervalo iProximo = intervalos.get(i+1);
            if (iAtual.getFim() <= iProximo.getInicio()) {
                System.out.println(iProximo.getId());
            }
        }
    }
}
