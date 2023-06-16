package grafo.utility;

import grafo.Aresta;
import grafo.Grafo;

import java.util.HashSet;
import java.util.Set;

public class ColorirArestas {
    public static int colorArestas(Grafo grafo) {
        int numColor = 0;
        for (Aresta aresta : grafo.getArestas()) {
            Set<Integer> usedColors = new HashSet<>();

            for (Aresta neighbor : aresta.getInicio().getArestaTodas()) {
                if (neighbor.getCor() != -1) {
                    usedColors.add(neighbor.getCor());
                }
            }

            int cor = 0;
            while (usedColors.contains(cor)) {
                cor++;
            }

            aresta.setCor(cor);
            if (cor+1 > numColor) {
                numColor = cor+1;
            }
        }
        return numColor;
    }
}
