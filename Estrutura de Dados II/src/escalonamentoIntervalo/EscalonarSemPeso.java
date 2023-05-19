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

//        System.out.println("Lista de intervalos:");
//        intervalos.forEach(System.out::println);
//        System.out.println();
        MostrarIntervalos.printIntervalos(intervalos);

        // organizar lista pela deadline mais curta (SDF)
        System.out.println("Lista ordenada:");
        intervalos.sort(Comparator.comparing(Intervalo::getFim));
        intervalos.forEach(System.out::println);
        System.out.println();

        Intervalo ultimo = intervalos.get(0);
        System.out.print("Intervalos: "+ultimo.getId()+" ");
        // verificar disjunção (não simultaneidade)
        for (int i=1; i< intervalos.size(); i++) {
            Intervalo atual = intervalos.get(i);
            if (ultimo.getFim() <= atual.getInicio()) {
                System.out.print(atual.getId()+" ");
                ultimo = atual;
            }
        }
    }
}
