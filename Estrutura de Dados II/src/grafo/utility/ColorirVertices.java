package grafo.utility;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

import java.util.*;

public class ColorirVertices {
    // colore os vertices e retorna o numero de cores usado
    public static int colorVertices(Grafo grafo) {
        int numColors = 0;
        for (Vertice vertice : grafo.getVertices()) {
            Set<Integer> usedColors = new HashSet<>();

            for (Vertice vizinho : vertice.getVizinhosBidirecional()) {
                if (vizinho.getCor() != -1) {
                    usedColors.add(vizinho.getCor());
                }
            }

            int cor = 0;
            while (usedColors.contains(cor)) {
                cor++;
            }
            vertice.setCor(cor);
            if (cor+1 > numColors) {
                numColors = cor+1;
            }
        }
        return numColors;
    }
}
